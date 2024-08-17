package app.kaito_dogi.mybrary.core.api.mybrary

import app.kaito_dogi.mybrary.core.api.mybrary.request.PostMemoRequest
import app.kaito_dogi.mybrary.core.api.mybrary.response.PostMemoResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MybraryAuthApi {
  @POST("/my-book")
  suspend fun postMyBook()

  @PUT("/my-book/{id}")
  suspend fun putMyBook(
    @Path("id") id: Long,
  )

  @DELETE("/my-book/{id}")
  suspend fun deleteMyBook(
    @Path("id") id: Long,
  )

  @POST("/memo")
  suspend fun postMemo(
    @Body request: PostMemoRequest,
  ): PostMemoResponse

  @PUT("/memo{id}")
  suspend fun putMemo(
    @Path("id") id: Long,
  )

  @DELETE("/memo{id}")
  suspend fun deleteMemo(
    @Path("id") id: Long,
  )
}
