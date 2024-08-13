package app.kaito_dogi.mybrary.core.domain.repository

interface AuthRepository {
  suspend fun sendOtp(email: String)

  suspend fun verifyOtp(
    email: String,
    otp: String,
  )

  suspend fun googleLogin()
}
