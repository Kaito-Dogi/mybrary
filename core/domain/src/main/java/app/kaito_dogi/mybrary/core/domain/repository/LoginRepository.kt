package app.kaito_dogi.mybrary.core.domain.repository

interface LoginRepository {
  suspend fun sendOneTimePassword(email: String)

  suspend fun googleLogin()
}
