package app.kaito_dogi.mybrary.core.domain.repository

interface LoginRepository {
  suspend fun emailLogin(
    email: String,
    password: String,
  )

  suspend fun googleLogin()
}
