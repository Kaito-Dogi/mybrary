package app.doggy.newmybrary.data.repository.interfaces

import app.doggy.newmybrary.domain.model.Book

interface BookRepository {
  suspend fun fetchBooksByIsbn(isbn: String): List<Book>
}
