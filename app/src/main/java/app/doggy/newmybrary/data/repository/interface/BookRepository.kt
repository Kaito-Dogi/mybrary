package app.doggy.newmybrary.data.repository.`interface`

import app.doggy.newmybrary.domain.model.Book

interface BookRepository {
  suspend fun fetchBooksByIsbn(): List<Book>
}
