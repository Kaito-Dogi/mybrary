package app.kaito_dogi.mybrary.core.api.mybrary

import app.kaito_dogi.mybrary.core.api.mybrary.request.PostEmailLoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface MybraryAnonApi {
  @POST("/email-login")
  suspend fun postEmailLogin(
    @Body request: PostEmailLoginRequest,
  )
}
