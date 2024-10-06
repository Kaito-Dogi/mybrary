package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.HCaptchaToken

interface SignUpRepository {
  suspend fun googleSignUp()

  suspend fun anonymousSignUp(hCaptchaToken: HCaptchaToken)
}
