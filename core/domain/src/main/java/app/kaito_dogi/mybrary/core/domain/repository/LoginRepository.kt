package app.kaito_dogi.mybrary.core.domain.repository

interface LoginRepository {
  // FIXME: OtpRepository に移動する
  suspend fun sendOtp(email: String)

  suspend fun googleLogin()
}
