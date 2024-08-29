package app.kaito_dogi.mybrary.core.api.mybrary

import app.kaito_dogi.mybrary.core.api.mybrary.request.PatchMemoRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PatchMyBookFavoriteRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostBookRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostMemoRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostMyBookRequest
import app.kaito_dogi.mybrary.core.api.mybrary.response.PatchMemoResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.PatchMyBookFavoriteResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.PostBookResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.PostMemoResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.PostMyBookResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface MybraryAuthApi {
  @POST("/book")
  suspend fun postBook(
    request: PostBookRequest,
  ): PostBookResponse

  @POST("/memo")
  suspend fun postMemo(
    @Body request: PostMemoRequest,
  ): PostMemoResponse

  @PATCH("/memo/{id}")
  suspend fun patchMemo(
    @Path("id") id: String,
    @Body request: PatchMemoRequest,
  ): PatchMemoResponse

  @DELETE("/memo/{id}")
  suspend fun deleteMemo(
    @Path("id") id: String,
  )

  @POST("/my-book")
  suspend fun postMyBook(
    request: PostMyBookRequest,
  ): PostMyBookResponse

  @PATCH("/my-book/{id}")
  suspend fun patchMyBook(
    @Path("id") id: String,
  )

  @PATCH("/my-book/{id}/favorite")
  suspend fun patchMyBookFavorite(
    @Path("id") id: String,
    @Body request: PatchMyBookFavoriteRequest,
  ): PatchMyBookFavoriteResponse

  @DELETE("/my-book/{id}")
  suspend fun deleteMyBook(
    @Path("id") id: String,
  )
}
