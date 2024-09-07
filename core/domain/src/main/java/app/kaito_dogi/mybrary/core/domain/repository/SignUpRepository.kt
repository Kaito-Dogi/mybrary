package app.kaito_dogi.mybrary.core.domain.repository

interface SignUpRepository {
  suspend fun googleSignUp()
}
