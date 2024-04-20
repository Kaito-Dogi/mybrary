package app.doggy.mybrary.core.network.api.book

import app.doggy.mybrary.core.domain.model.Book

interface BookApi {
  suspend fun searchBooksByIsbn(
    isbn: String,
    limit: Int,
    pageIndex: Int,
  ): List<Book>
}
