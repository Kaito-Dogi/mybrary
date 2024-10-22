package app.kaito_dogi.mybrary.core.repository

import app.kaito_dogi.mybrary.core.api.rakuten.RakutenApi
import app.kaito_dogi.mybrary.core.api.rakuten.response.ItemResponse
import app.kaito_dogi.mybrary.core.common.coroutines.AppDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.AppDispatchers
import app.kaito_dogi.mybrary.core.config.AppConfig
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.Genre
import app.kaito_dogi.mybrary.core.domain.model.Sort
import app.kaito_dogi.mybrary.core.domain.repository.BookRepository
import app.kaito_dogi.mybrary.core.repository.convertor.toBook
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class DefaultBookRepository @Inject constructor(
  private val rakutenApi: RakutenApi,
  private val appConfig: AppConfig,
  @AppDispatcher(AppDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : BookRepository {
  override suspend fun getBook(id: BookId): Book = withContext(dispatcher) {
    TODO("Not yet implemented")
  }

  override suspend fun searchBook(
    title: String?,
    isbn: String?,
    author: String?,
    publisher: String?,
    genre: Genre,
    hits: Int,
    page: Int,
    sort: Sort,
  ): List<Book> = withContext(dispatcher) {
    val response = rakutenApi.getBooksBookSearch(
      applicationId = appConfig.rakutenApplicationId,
      affiliateId = appConfig.rakutenAffiliateId,
      title = title,
      author = author,
      publisherName = publisher,
      size = genre.value,
      isbn = isbn,
      hits = hits,
      page = page,
      sort = sort.value,
    )
    return@withContext response.items.map(ItemResponse::toBook)
  }
}
