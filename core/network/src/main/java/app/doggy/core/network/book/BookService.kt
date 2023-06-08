package app.doggy.core.network.book

import app.doggy.core.network.book.response.GetVolumesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

  @GET("volumes")
  suspend fun getVolumes(
    @Query("q") q: String,
    @Query("maxResults") maxResult: Int,
    @Query("startIndex") startIndex: Int,
  ): Response<GetVolumesResponse>
}
