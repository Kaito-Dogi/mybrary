package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.Genre
import app.kaito_dogi.mybrary.core.domain.model.Sort

interface BookRepository {
  suspend fun getBook(id: BookId): Book

  // FIXME: Paging できるようにする
  suspend fun searchBook(
    title: String?,
    isbn: String?,
    author: String? = null,
    publisher: String? = null,
    genre: Genre = Genre.All,
    hits: Int = 30,
    page: Int = 1,
    sort: Sort = Sort.Default,
  ): List<Book>
}
