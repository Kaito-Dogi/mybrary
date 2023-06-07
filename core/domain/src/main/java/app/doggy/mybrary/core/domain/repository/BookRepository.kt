package app.doggy.mybrary.core.domain.repository

import app.doggy.mybrary.core.domain.model.Book

interface BookRepository {
  suspend fun fetchBooksByIsbn(isbn: String): List<Book>

  suspend fun getBooks(): List<Book>

  suspend fun getBook(bookId: Long): Book

  suspend fun registerBook(book: Book): Boolean
}
