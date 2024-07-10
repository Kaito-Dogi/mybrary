package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.ExternalBookId
import app.kaito_dogi.mybrary.core.domain.model.SearchResultBook

interface SearchBooksRepository {
  // TODO: orderBy を指定できるようにする
  suspend fun searchBooks(
    query: String,
    maxResults: Int = 10,
    startIndex: Int = 0,
  ): List<SearchResultBook>

  suspend fun searchBook(id: ExternalBookId): SearchResultBook
}
