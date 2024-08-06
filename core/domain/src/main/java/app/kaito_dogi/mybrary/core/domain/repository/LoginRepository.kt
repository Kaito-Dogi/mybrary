package app.kaito_dogi.mybrary.core.domain.repository

interface LoginRepository {
  suspend fun sendOtp(email: String)

  suspend fun googleLogin()
}
