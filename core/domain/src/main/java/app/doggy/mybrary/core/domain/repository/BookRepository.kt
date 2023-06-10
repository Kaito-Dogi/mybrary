package app.doggy.mybrary.core.domain.repository

import app.doggy.mybrary.core.domain.model.book.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {

  suspend fun registerBook(book: Book)

  suspend fun updateBook(book: Book)

  suspend fun deleteBook(bookId: Long)

  fun getBooks(): Flow<List<Book>>

  fun getBook(bookId: Long): Flow<Book>

  fun searchBooksByIsbn(
    isbn: String,
    limit: Int,
    pageIndex: Int,
  ): Flow<List<Book>>
}
