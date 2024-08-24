package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.delay

@Singleton
internal class MockAuthRepository @Inject constructor() : AuthRepository {
  override suspend fun sendOtp(email: String) {
    delay(1_000)
  }

  override suspend fun verifyOtp(email: String, otp: String) {
    delay(1_000)
  }

  override suspend fun googleLogin() {
    TODO("Not yet implemented")
  }

  override suspend fun hasSession(): Boolean {
    TODO("Not yet implemented")
  }
}
