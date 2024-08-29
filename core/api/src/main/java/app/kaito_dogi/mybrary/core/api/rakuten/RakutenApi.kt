package app.kaito_dogi.mybrary.core.api.rakuten

import app.kaito_dogi.mybrary.core.api.rakuten.response.GetBooksBookSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RakutenApi {
  @GET("/services/api/BooksBook/Search/20170404")
  suspend fun getBooksBookSearch(
    @Query("applicationId") applicationId: String,
    @Query("affiliateId") affiliateId: String,
    @Query("title") title: String?,
    @Query("author") author: String?,
    @Query("publisherName") publisherName: String?,
    @Query("size") size: Int,
    @Query("isbn") isbn: String?,
    @Query("hits") hits: Int,
    @Query("page") page: Int,
    @Query("sort") sort: String,
    @Query("format") format: String = "json",
    @Query("elements") elements: String = "count,page,affiliateUrl,author,isbn,publisherName,salesDate,size,smallImageUrl,title",
    @Query("formatVersion") formatVersion: Int = 2,
    @Query("outOfStockFlag") outOfStockFlag: Int = 1,
  ): GetBooksBookSearchResponse
}

