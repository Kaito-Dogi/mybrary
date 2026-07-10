package app.kaito_dogi.mybrary.core.api.rakuten

import app.kaito_dogi.mybrary.core.api.rakuten.response.GetBooksBookSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RakutenApi {
  @GET("/services/api/BooksBook/Search/20170404")
  suspend fun getBooksBookSearch(
    @Query(value = "applicationId") applicationId: String,
    @Query(value = "affiliateId") affiliateId: String,
    @Query(value = "title") title: String?,
    @Query(value = "author") author: String?,
    @Query(value = "publisherName") publisherName: String?,
    @Query(value = "size") size: Int,
    @Query(value = "isbn") isbn: String?,
    @Query(value = "hits") hits: Int,
    @Query(value = "page") page: Int,
    @Query(value = "sort") sort: String,
    @Query(value = "format") format: String = "json",
    @Query(value = "elements") elements: String = "count,page,affiliateUrl,author,isbn,publisherName,salesDate,size,smallImageUrl,title",
    @Query(value = "formatVersion") formatVersion: Int = 2,
    @Query(value = "outOfStockFlag") outOfStockFlag: Int = 1,
  ): GetBooksBookSearchResponse
}
