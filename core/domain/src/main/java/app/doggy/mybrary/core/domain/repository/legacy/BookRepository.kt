package app.doggy.mybrary.core.domain.repository.legacy

import app.doggy.mybrary.core.domain.model.legacy.Book

interface BookRepository {
  suspend fun fetchBooksByIsbn(isbn: String): List<Book>

  suspend fun getBooks(): List<Book>

  suspend fun getBook(bookId: Long): Book

  suspend fun registerBook(book: Book): Boolean
}
