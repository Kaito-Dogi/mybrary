package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.HCaptchaToken

interface LoginRepository {
  suspend fun googleLogin()

  suspend fun anonymousLogin(hCaptchaToken: HCaptchaToken)
}
