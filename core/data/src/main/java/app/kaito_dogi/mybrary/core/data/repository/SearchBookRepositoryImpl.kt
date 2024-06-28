package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.api.googlebooks.GoogleBooksApi
import app.kaito_dogi.mybrary.core.api.googlebooks.response.model.ItemResponse
import app.kaito_dogi.mybrary.core.data.convertor.toSearchResultBook
import app.kaito_dogi.mybrary.core.domain.model.ExternalBookId
import app.kaito_dogi.mybrary.core.domain.model.SearchResultBook
import app.kaito_dogi.mybrary.core.domain.repository.SearchBookRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class SearchBookRepositoryImpl @Inject constructor(
  private val googleBooksApi: GoogleBooksApi,
) : SearchBookRepository {
  override suspend fun searchBooks(
    query: String,
    maxResults: Int,
    startIndex: Int,
  ): List<SearchResultBook> {
    val response = googleBooksApi.getVolumes(
      query = query,
      maxResults = maxResults,
      startIndex = startIndex,
    )
    return response.items.map(ItemResponse::toSearchResultBook)
  }

  override suspend fun searchBook(id: ExternalBookId): SearchResultBook {
    val response = googleBooksApi.getVolume(volumeId = id.value)
    return response.toSearchResultBook()
  }
}
