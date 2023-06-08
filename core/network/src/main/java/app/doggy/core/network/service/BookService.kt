package app.doggy.core.network.service

import app.doggy.core.network.RetrofitManager
import app.doggy.core.network.response.FetchBooksResponse
import javax.inject.Inject
import retrofit2.Response
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

// FIXME: service の配り方を考える
class BookApi @Inject constructor(
  retrofitManager: RetrofitManager,
) {
  val service = retrofitManager.retrofit.create<BookService>()
}

interface BookService {
  @GET("volumes")
  suspend fun fetchBooksByIsbn(@Query("q") isbn: String): Response<FetchBooksResponse>
}
