package app.kaito_dogi.mybrary.core.network.api.book

import app.kaito_dogi.mybrary.core.domain.model.Book

interface BookApi {
  suspend fun searchBooksByIsbn(
    isbn: String,
    limit: Int,
    pageIndex: Int,
  ): List<Book>
}
