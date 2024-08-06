package app.kaito_dogi.mybrary.core.api.mybrary

import app.kaito_dogi.mybrary.core.api.mybrary.request.PostSendOtpRequest
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMemos
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMyBookResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMyBooksResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MybraryAnonApi {
  @POST("/send-otp")
  suspend fun postSendOtp(
    @Body request: PostSendOtpRequest,
  )

  @GET("/my-books")
  suspend fun getMyBooks(): GetMyBooksResponse

  @GET("/my-book/{id}")
  suspend fun getMyBook(
    @Path("id") myBookId: Long,
  ): GetMyBookResponse

  @GET("/my-book/{myBookId}/memos")
  suspend fun getMemos(
    @Path("myBookId") myBookId: Long,
  ): GetMemos

  @GET("/user/{user-id}")
  suspend fun getUser()
}
