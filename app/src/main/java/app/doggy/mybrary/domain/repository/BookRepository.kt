package app.doggy.mybrary.domain.repository

import app.doggy.mybrary.domain.model.Book

interface BookRepository {
  suspend fun fetchBooksByIsbn(isbn: String): List<Book>

  suspend fun getBooks(): List<Book>

  suspend fun getBook(bookId: Long): Book

  suspend fun registerBook(book: Book): Boolean
}
