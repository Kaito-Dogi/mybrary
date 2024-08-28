package app.kaito_dogi.mybrary.core.api.google

import app.kaito_dogi.mybrary.core.api.google.response.GetVolumeResponse
import app.kaito_dogi.mybrary.core.api.google.response.GetVolumesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleApi {
  @GET("/books/v1/volumes")
  suspend fun getVolumes(
    @Query("q") query: String,
    @Query("maxResults") maxResults: Int,
    @Query("startIndex") startIndex: Int,
  ): GetVolumesResponse

  @GET("/books/v1/volumes/{volumeId}")
  suspend fun getVolume(
    @Path("volumeId") volumeId: String,
  ): GetVolumeResponse
}
