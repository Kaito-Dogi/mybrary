package app.kaito_dogi.mybrary.core.repository.mock

import app.kaito_dogi.mybrary.core.domain.model.HCaptchaToken
import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import javax.inject.Inject
import kotlinx.coroutines.delay

internal class MockAuthRepository @Inject constructor() : AuthRepository {
  override suspend fun sendOtp(
    email: String,
    captchaToken: HCaptchaToken,
  ) {
    delay(1_000)
  }

  override suspend fun verifyOtp(
    email: String,
    otp: String,
    captchaToken: HCaptchaToken,
  ) {
    delay(1_000)
  }

  override suspend fun googleSignIn() {
    delay(1_000L)
  }

  override suspend fun anonymousSignIn(captchaToken: HCaptchaToken) {
    delay(1_000L)
  }

  override suspend fun logout() {
    delay(1_000)
  }
}
