package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.ExternalBookId

// TODO: BookRepository と統合する
interface SearchBooksRepository {
  // TODO: orderBy を指定できるようにする
  suspend fun searchBooks(
    query: String,
    maxResults: Int = 10,
    startIndex: Int = 0,
  ): List<Book>

  suspend fun searchBook(id: ExternalBookId): Book
}
