package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.api.googlebooks.GoogleBooksApi
import app.kaito_dogi.mybrary.core.api.googlebooks.response.model.ItemResponse
import app.kaito_dogi.mybrary.core.data.convertor.toBook
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.ExternalBookId
import app.kaito_dogi.mybrary.core.domain.repository.SearchBooksRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class SearchBooksRepositoryImpl @Inject constructor(
  private val googleBooksApi: GoogleBooksApi,
) : SearchBooksRepository {
  override suspend fun searchBooks(
    query: String,
    maxResults: Int,
    startIndex: Int,
  ): List<Book> {
    val response = googleBooksApi.getVolumes(
      query = query,
      maxResults = maxResults,
      startIndex = startIndex,
    )
    return response.items.map(ItemResponse::toBook)
  }

  override suspend fun searchBook(id: ExternalBookId): Book {
    val response = googleBooksApi.getVolume(volumeId = id.value)
    return response.toBook()
  }
}
