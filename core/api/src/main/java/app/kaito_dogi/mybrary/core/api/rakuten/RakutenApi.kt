package app.kaito_dogi.mybrary.core.api.rakuten

import app.kaito_dogi.mybrary.core.api.rakuten.response.GetBooksBookSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RakutenApi {
  @GET("/BooksBook/Search/20170404")
  suspend fun getBooksBookSearch(
    @Query("applicationId") applicationId: String,
    @Query("affiliateId") affiliateId: String,
    @Query("elements") elements: String = "count,page,affiliateUrl,author,isbn,publisherName,salesDate,size,smallImageUrl,title",
    @Query("formatVersion") formatVersion: Int = 2,
    @Query("title") title: String,
    @Query("author") author: String,
    @Query("publisherName") publisherName: String,
    @Query("size") size: Int,
    @Query("isbn") isbn: String,
    @Query("hits") hits: Int,
    @Query("page") page: Int,
    @Query("outOfStockFlag") outOfStockFlag: Int = 1,
    @Query("sort") sort: String,
  ): GetBooksBookSearchResponse
}
