package app.doggy.core.network.retrofit.service

import app.doggy.core.network.api.book.response.GetVolumesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

  @GET("volumes")
  suspend fun getVolumes(
    @Query("q") q: String,
    @Query("maxResults") maxResults: Int,
    @Query("startIndex") startIndex: Int,
  ): Response<GetVolumesResponse>
}
