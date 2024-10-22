package app.kaito_dogi.mybrary.feature.signup

import androidx.compose.runtime.Immutable

@Immutable
internal data class SignUpUiState(
  val email: String,
  val isOtpSending: Boolean,
  val isAnonymousSigningUp: Boolean,
  val isGoogleSigningUp: Boolean,
) {
  companion object {
    val InitialValue = SignUpUiState(
      email = "",
      isOtpSending = false,
      isAnonymousSigningUp = false,
      isGoogleSigningUp = false,
    )
  }

  val isHCaptchaVisible: Boolean = isOtpSending || isAnonymousSigningUp
}
