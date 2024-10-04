package app.kaito_dogi.mybrary.core.api.mybrary

import app.kaito_dogi.mybrary.core.api.mybrary.request.PostSendOtpRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostVerifyOtpRequest
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetBookByIsbnResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMemosResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMyBookResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMyBooksResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MybraryAnonApi {
  @POST("/anonymous-login")
  suspend fun anonymousLogin()

  @POST("/anonymous-sign-up")
  suspend fun anonymousSignUp()

  @GET("/book/{isbn}")
  suspend fun getBookByIsbn(
    @Path("isbn") isbn: String,
  ): GetBookByIsbnResponse

  @GET("/my-book/{myBookId}/memos")
  suspend fun getMemos(
    @Path("myBookId") myBookId: String,
  ): GetMemosResponse

  @GET("/my-book/{id}")
  suspend fun getMyBook(
    @Path("id") myBookId: String,
  ): GetMyBookResponse

  @GET("/my-books")
  suspend fun getMyBooks(): GetMyBooksResponse

  @GET("/user/{user-id}")
  suspend fun getUser()

  @POST("/send-otp")
  suspend fun postSendOtp(
    @Body request: PostSendOtpRequest,
  )

  @POST("/verify-otp")
  suspend fun postVerifyOtp(
    @Body request: PostVerifyOtpRequest,
  )

  @DELETE("/logout")
  suspend fun logout()

  // FIXME: 適切な定義箇所に移動する
  suspend fun getSession(): Boolean
}
