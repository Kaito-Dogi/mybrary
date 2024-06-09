package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.data.model.dummyMyBooks
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import javax.inject.Inject
import kotlinx.coroutines.delay

internal class MockMyBookRepository @Inject constructor() : MyBookRepository {
  override suspend fun getMyBooks(): List<MyBook> {
    delay(1_000)
    return dummyMyBooks
  }

  override suspend fun getMyBook(
    myBookId: MyBookId,
  ): MyBook {
    return dummyMyBooks.first { it.id == myBookId }
  }

  override suspend fun registerBook(
    externalBookId: String,
  ): Boolean {
    return true
  }

  override suspend fun pinBook(
    myBookId: MyBookId,
  ): MyBook {
    return dummyMyBooks
      .first { it.id == myBookId }
      .copy(isPinned = true)
  }

  override suspend fun makeBookFavorite(
    myBookId: MyBookId,
  ): MyBook {
    return dummyMyBooks
      .first { it.id == myBookId }
      .copy(isFavorite = true)
  }

  override suspend fun archiveBook(
    myBookId: MyBookId,
  ): MyBook {
    return dummyMyBooks
      .first { it.id == myBookId }
      .copy(isArchived = true)
  }
}
