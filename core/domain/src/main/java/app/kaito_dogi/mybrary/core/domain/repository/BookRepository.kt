package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.BookId

interface BookRepository {
  suspend fun getBook(id: BookId): Book

  suspend fun searchBook(
    title: String,
    author: String,
    publisher: String,
    // FIXME: Enum で指定できるようにする
    size: Int,
    isbn: String,
    hits: Int,
    page: Int,
    // FIXME: Enum で指定できるようにする
    sort: String,
  ): List<Book>
}
