package app.kaito_dogi.mybrary.feature.signin

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.common.model.CaptchaToken

@Immutable
internal data class SignInUiState(
  val email: String,
  val captchaToken: CaptchaToken?,
  val isOtpSending: Boolean,
  val isGoogleSigningIn: Boolean,
) {
  companion object {
    val InitialValue = SignInUiState(
      email = "",
      captchaToken = null,
      isOtpSending = false,
      isGoogleSigningIn = false,
    )
  }

  val isHCaptchaVisible: Boolean = isOtpSending
}
