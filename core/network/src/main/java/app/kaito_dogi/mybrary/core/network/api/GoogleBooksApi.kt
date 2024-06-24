package app.kaito_dogi.mybrary.core.network.api

import app.kaito_dogi.mybrary.core.network.response.GetVolumeResponse
import app.kaito_dogi.mybrary.core.network.response.GetVolumesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBooksApi {
  @GET("/volumes")
  suspend fun getVolumes(
    @Query("q") q: String,
    @Query("maxResults") maxResults: Int,
    @Query("startIndex") startIndex: Int,
  ): Response<GetVolumesResponse>

  @GET("/volumes/{volumeId}")
  suspend fun getVolume(
    @Query("volumeId") volumeId: String,
  ): Response<GetVolumeResponse>
}
