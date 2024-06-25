package app.kaito_dogi.mybrary.core.network.api

import app.kaito_dogi.mybrary.core.network.response.GetVolumeResponse
import app.kaito_dogi.mybrary.core.network.response.GetVolumesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleBooksApi {
  @GET("/books/v1/volumes")
  suspend fun getVolumes(
    @Query("q") q: String,
    @Query("maxResults") maxResults: Int,
    @Query("startIndex") startIndex: Int,
  ): GetVolumesResponse

  @GET("/books/v1/volumes/{volumeId}")
  suspend fun getVolume(
    @Path("volumeId") volumeId: String,
  ): GetVolumeResponse
}
