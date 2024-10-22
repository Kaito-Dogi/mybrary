package app.kaito_dogi.mybrary.core.repository.mock

import app.kaito_dogi.mybrary.core.common.model.CaptchaToken
import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import javax.inject.Inject
import kotlinx.coroutines.delay

internal class MockAuthRepository @Inject constructor() : AuthRepository {
  override suspend fun sendOtp(
    email: String,
    captchaToken: CaptchaToken,
  ) {
    delay(1_000)
  }

  override suspend fun verifyOtp(
    email: String,
    otp: String,
    captchaToken: CaptchaToken,
  ) {
    delay(1_000)
  }

  override suspend fun googleSignIn() {
    delay(1_000L)
  }

  override suspend fun anonymousSignIn(captchaToken: CaptchaToken) {
    delay(1_000L)
  }

  override suspend fun logout() {
    delay(1_000)
  }

  override suspend fun hasCurrentSession(): Boolean {
    delay(1_000)

    return false
  }
}
