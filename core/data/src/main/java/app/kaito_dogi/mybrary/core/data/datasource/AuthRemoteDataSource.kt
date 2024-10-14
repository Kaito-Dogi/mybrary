package app.kaito_dogi.mybrary.core.data.datasource

interface AuthRemoteDataSource {
  suspend fun sendOtp(
    email: String,
    captchaToken: String,
  )

  suspend fun verifyOtp(
    email: String,
    otp: String,
    captchaToken: String,
  )

  suspend fun googleSignIn()

  suspend fun anonymousSignIn(captchaToken: String)

  suspend fun logout()
}
