package app.kaito_dogi.mybrary.core.repository

import app.kaito_dogi.mybrary.core.common.coroutines.AppDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.AppDispatchers
import app.kaito_dogi.mybrary.core.database.MyBookDao
import app.kaito_dogi.mybrary.core.database.MyBookEntity
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import app.kaito_dogi.mybrary.core.repository.convertor.toMyBook
import app.kaito_dogi.mybrary.core.repository.convertor.toMyBookEntity
import java.util.UUID
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class DefaultMyBookRepository @Inject constructor(
  private val myBookDao: MyBookDao,
  @param:AppDispatcher(appDispatchers = AppDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : MyBookRepository {
  override suspend fun getMyBookList(): List<MyBook> = withContext(dispatcher) {
    myBookDao.getAll().map(MyBookEntity::toMyBook)
  }

  override suspend fun getMyBook(myBookId: MyBookId): MyBook = withContext(dispatcher) {
    requireNotNull(value = myBookDao.getById(id = myBookId.value)) {
      "MyBook が見つかりません: ${myBookId.value}"
    }.toMyBook()
  }

  override suspend fun addBookToMybrary(book: Book): MyBook = withContext(dispatcher) {
    // 同じ ISBN の本が登録済みの場合は、その本を返す
    if (book.isbn.isNotBlank()) {
      val recordedEntity = myBookDao.getByIsbn(isbn = book.isbn)
      if (recordedEntity != null) return@withContext recordedEntity.toMyBook()
    }

    val entity = book.toMyBookEntity(
      id = UUID.randomUUID().toString(),
      createdAt = System.currentTimeMillis(),
    )
    myBookDao.upsert(entity = entity)
    entity.toMyBook()
  }

  override suspend fun pinMyBook(myBookId: MyBookId): MyBook =
    updateMyBook(myBookId = myBookId) { it.copy(isPinned = true) }

  override suspend fun addMyBookToFavorites(myBookId: MyBookId): MyBook =
    updateMyBook(myBookId = myBookId) { it.copy(isFavorite = true) }

  override suspend fun removeMyBookFromFavorites(myBookId: MyBookId): MyBook =
    updateMyBook(myBookId = myBookId) { it.copy(isFavorite = false) }

  override suspend fun archiveMyBook(myBookId: MyBookId): MyBook =
    updateMyBook(myBookId = myBookId) { it.copy(isArchived = true) }

  private suspend fun updateMyBook(
    myBookId: MyBookId,
    transform: (MyBookEntity) -> MyBookEntity,
  ): MyBook = withContext(dispatcher) {
    val entity = requireNotNull(value = myBookDao.getById(id = myBookId.value)) {
      "MyBook が見つかりません: ${myBookId.value}"
    }
    val newEntity = transform(entity)
    myBookDao.upsert(entity = newEntity)
    newEntity.toMyBook()
  }
}
