package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.Genre
import app.kaito_dogi.mybrary.core.domain.model.Sort

interface BookRepository {
  suspend fun getBook(id: BookId): Book

  suspend fun searchBook(
    title: String,
    isbn: String,
    genre: Genre = Genre.All,
    hits: Int = 30,
    page: Int = 0,
    sort: Sort = Sort.Default,
  ): List<Book>
}
