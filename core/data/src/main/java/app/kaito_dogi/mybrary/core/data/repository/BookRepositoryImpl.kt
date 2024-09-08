package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.api.rakuten.RakutenApi
import app.kaito_dogi.mybrary.core.api.rakuten.response.ItemResponse
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatchers
import app.kaito_dogi.mybrary.core.config.MybraryConfig
import app.kaito_dogi.mybrary.core.data.convertor.toBook
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.Genre
import app.kaito_dogi.mybrary.core.domain.model.Sort
import app.kaito_dogi.mybrary.core.domain.repository.BookRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

@Singleton
internal class BookRepositoryImpl @Inject constructor(
  private val rakutenApi: RakutenApi,
  private val config: MybraryConfig,
  @MybraryDispatcher(MybraryDispatchers.Io) private val dispatcher: CoroutineDispatcher,
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
      applicationId = config.rakutenApplicationId,
      affiliateId = config.rakutenAffiliateId,
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
