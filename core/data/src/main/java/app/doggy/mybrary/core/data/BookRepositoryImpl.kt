package app.doggy.mybrary.core.data

import app.doggy.core.common.coroutines.dispatcher.Dispatcher
import app.doggy.core.common.coroutines.dispatcher.MybraryDispatchers
import app.doggy.core.database.dao.AuthorDao
import app.doggy.core.database.dao.BookDao
import app.doggy.core.database.entity.toBookWithAuthors
import app.doggy.core.database.util.RoomTransactionExecutor
import app.doggy.core.network.api.book.BookApi
import app.doggy.mybrary.core.domain.model.book.Book
import app.doggy.mybrary.core.domain.model.book.BookId
import app.doggy.mybrary.core.domain.model.record.Record
import app.doggy.mybrary.core.domain.repository.BookRepository
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class BookRepositoryImpl @Inject constructor(
  private val bookApi: BookApi,
  private val bookDao: BookDao,
  private val authorDao: AuthorDao,
  private val roomTransactionExecutor: RoomTransactionExecutor,
  @Dispatcher(MybraryDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : BookRepository {

  override suspend fun registerBook(book: Book) = withContext(ioDispatcher) {
    val bookWithAuthors = book.toBookWithAuthors()

    roomTransactionExecutor.execute {
      bookDao.upsertBook(bookWithAuthors.book)
      authorDao.upsertAuthors(bookWithAuthors.authors)
    }

    return@withContext
  }

  override suspend fun updateBook(book: Book) {
    TODO("Not yet implemented")
  }

  override suspend fun deleteBook(bookId: BookId) {
    bookDao.deleteBookById(bookId = bookId.value)
  }

  override fun getBooks(): Flow<List<Book>> {
    TODO("Not yet implemented")
  }

  override fun getBook(bookId: BookId): Flow<Book> {
    TODO("Not yet implemented")
  }

  override fun getBookWithRecords(bookId: BookId): Flow<Map<Book, List<Record>>> {
    TODO("Not yet implemented")
  }

  override fun searchBooksByIsbn(isbn: String, limit: Int, pageIndex: Int): Flow<List<Book>> {
    TODO("Not yet implemented")
  }
}
