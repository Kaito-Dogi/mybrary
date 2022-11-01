package app.doggy.newmybrary.data.api.service

import app.doggy.newmybrary.data.api.response.FetchBooksResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {
  @GET("volumes")
  suspend fun fetchBookByIsbn(@Query("q") isbn: String): Response<FetchBooksResponse>
}
