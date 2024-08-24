package app.kaito_dogi.mybrary.core.api.mybrary

import app.kaito_dogi.mybrary.core.api.mybrary.request.PatchMemoRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PatchMyBookFavoriteRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostMemoRequest
import app.kaito_dogi.mybrary.core.api.mybrary.response.PatchMemoResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.PatchMyBookFavoriteResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.PostMemoResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MybraryAuthApi {
  @POST("/my-book")
  suspend fun postMyBook()

  @PATCH("/my-book/{id}")
  suspend fun putMyBook(
    @Path("id") id: Long,
  )

  @PATCH("/my-book/{id}/favorite")
  suspend fun patchMyBookFavorite(
    @Path("id") id: Long,
  ): PatchMyBookFavoriteResponse

  @DELETE("/my-book/{id}")
  suspend fun deleteMyBook(
    @Path("id") id: Long,
  )

  @POST("/memo")
  suspend fun postMemo(
    @Body request: PostMemoRequest,
  ): PostMemoResponse

  @PATCH("/memo/{id}")
  suspend fun patchMemo(
    @Path("id") id: Long,
    @Body request: PatchMemoRequest,
  ): PatchMemoResponse

  @DELETE("/memo{id}")
  suspend fun deleteMemo(
    @Path("id") id: Long,
  )
}
