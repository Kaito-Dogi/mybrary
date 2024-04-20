package app.doggy.mybrary.core.data.impl

import app.doggy.mybrary.core.common.coroutines.dispatcher.Dispatcher
import app.doggy.mybrary.core.common.coroutines.dispatcher.MybraryDispatchers
import app.doggy.mybrary.core.database.dao.AuthorDao
import app.doggy.mybrary.core.database.dao.BookDao
import app.doggy.mybrary.core.database.entity.toBookWithAuthors
import app.doggy.mybrary.core.database.util.RoomTransactionExecutor
import app.doggy.mybrary.core.domain.legacy.model.book.Book
import app.doggy.mybrary.core.domain.legacy.model.book.BookId
import app.doggy.mybrary.core.domain.legacy.model.record.Record
import app.doggy.mybrary.core.domain.repository.BookRepository
import app.doggy.mybrary.core.network.api.book.BookApi
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

internal class BookRepositoryImpl @Inject constructor(
  private val bookApi: BookApi,
  private val bookDao: BookDao,
  private val authorDao: AuthorDao,
  private val roomTransactionExecutor: RoomTransactionExecutor,
  @Dispatcher(MybraryDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : BookRepository {

  override suspend fun registerBook(book: Book) {
    withContext(ioDispatcher) {
      val bookWithAuthors = book.toBookWithAuthors()

      roomTransactionExecutor.execute {
        bookDao.upsertBook(bookWithAuthors.book)
        authorDao.upsertAuthors(bookWithAuthors.authors)
      }
    }
  }

  override suspend fun updateBook(book: Book) {
    // author の数が減った場合、元々保存してあった author のうち、減った分を削除する
    authorDao.getAuthorsByBookId(bookId = book.id.value)
      .map { prevAuthorList ->
        prevAuthorList.filter { prevAuthor ->
          book.authors.any { author ->
            author.id.value == prevAuthor.id
          }
        }
      }.collect {
        authorDao.deleteAuthors(it)
      }

    withContext(ioDispatcher) {
      val bookWithAuthors = book.toBookWithAuthors()

      roomTransactionExecutor.execute {
        bookDao.upsertBook(bookWithAuthors.book)
        authorDao.upsertAuthors(bookWithAuthors.authors)
      }
    }
  }

  override suspend fun deleteBook(bookId: BookId) {
    withContext(ioDispatcher) {
      bookDao.deleteBookById(bookId = bookId.value)
    }
  }

  override fun getBooks(): Flow<List<Book>> = bookDao.getAllBooks()
    .map { books ->
      books.map { it.toBook() }
    }

  override fun getBook(bookId: BookId): Flow<Book> = bookDao.getBookById(bookId = bookId.value)
    .map { it.toBook() }

  override fun getBookWithRecords(bookId: BookId): Flow<Pair<Book, List<Record>>> =
    bookDao.getBookWithRecordById(bookId = bookId.value)
      .map { it.toBookWithRecord() }

  override fun searchBooksByIsbn(
    isbn: String,
    limit: Int,
    pageIndex: Int,
  ): Flow<List<Book>> = flow {
    emit(
      bookApi.searchBooksByIsbn(
        isbn = isbn,
        limit = limit,
        pageIndex = pageIndex,
      ),
    )
  }
}
