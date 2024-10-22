package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.common.model.CaptchaToken

interface AuthRepository {
  suspend fun sendOtp(
    email: String,
    captchaToken: CaptchaToken,
  )

  suspend fun verifyOtp(
    email: String,
    otp: String,
    captchaToken: CaptchaToken,
  )

  suspend fun googleSignIn()

  suspend fun anonymousSignIn(captchaToken: CaptchaToken)

  suspend fun logout()

  suspend fun hasCurrentSession(): Boolean
}
