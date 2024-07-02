package app.kaito_dogi.mybrary.core.api.googlebooks

import app.kaito_dogi.mybrary.core.api.googlebooks.response.GetVolumeResponse
import app.kaito_dogi.mybrary.core.api.googlebooks.response.GetVolumesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleBooksApi {
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
