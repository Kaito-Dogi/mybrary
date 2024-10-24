package app.kaito_dogi.mybrary.core.data.datasource

interface AuthRemoteDataSource {
  suspend fun otpSignIn(
    email: String,
    captchaToken: String,
  )

  suspend fun otpSignUp(
    email: String,
    captchaToken: String,
  )

  suspend fun verifyOtp(
    email: String,
    otp: String,
    captchaToken: String,
  )

  suspend fun resendOtp(
    email: String,
    captchaToken: String,
  )

  suspend fun googleSignIn()

  suspend fun googleSignUp()

  suspend fun anonymousSignIn(captchaToken: String)

  suspend fun logout()

  suspend fun hasCurrentSession(): Boolean
}
