package app.doggy.newmybrary.domain.repository

import app.doggy.newmybrary.domain.model.Book

interface BookRepository {
  suspend fun fetchBooksByIsbn(isbn: String): List<Book>

  suspend fun getBooks(): List<Book>

  suspend fun registerBook(book: Book): Boolean
}
