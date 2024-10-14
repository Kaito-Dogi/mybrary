package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.HCaptchaToken

interface AuthRepository {
  suspend fun sendOtp(
    email: String,
    captchaToken: HCaptchaToken,
  )

  suspend fun verifyOtp(
    email: String,
    otp: String,
    captchaToken: HCaptchaToken,
  )

  suspend fun googleSignIn()

  suspend fun anonymousSignIn(captchaToken: HCaptchaToken)

  suspend fun logout()
}
