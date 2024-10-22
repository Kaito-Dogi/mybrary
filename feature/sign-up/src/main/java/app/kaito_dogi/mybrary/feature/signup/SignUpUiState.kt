package app.kaito_dogi.mybrary.feature.signup

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.ui.model.HCaptchaPurpose

@Immutable
internal class SignUpUiState(
  val email: String,
  val isOtpSending: Boolean,
  val isAnonymousSigningUp: Boolean,
  val isGoogleSigningUp: Boolean,
  val hCaptchaPurpose: HCaptchaPurpose?,
) {
  companion object {
    val InitialValue = SignUpUiState(
      email = "",
      isOtpSending = false,
      isAnonymousSigningUp = false,
      isGoogleSigningUp = false,
      hCaptchaPurpose = null,
    )
  }

  val isHCaptchaVisible: Boolean = hCaptchaPurpose != null
}
