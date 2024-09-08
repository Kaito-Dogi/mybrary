package app.kaito_dogi.mybrary.core.domain.repository

interface LoginRepository {
  suspend fun googleLogin()
}
