package app.kaito_dogi.mybrary.feature.signup

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.common.model.CaptchaToken

@Immutable
internal data class SignUpUiState(
  val email: String,
  val captchaToken: CaptchaToken?,
  val isOtpSending: Boolean,
  val isAnonymousSigningUp: Boolean,
  val isGoogleSigningUp: Boolean,
) {
  companion object {
    val InitialValue = SignUpUiState(
      email = "",
      captchaToken = null,
      isOtpSending = false,
      isAnonymousSigningUp = false,
      isGoogleSigningUp = false,
    )
  }

  val isHCaptchaVisible: Boolean = isOtpSending || isAnonymousSigningUp
}
