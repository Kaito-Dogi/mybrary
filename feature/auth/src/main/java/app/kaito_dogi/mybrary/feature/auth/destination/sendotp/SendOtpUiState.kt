package app.kaito_dogi.mybrary.feature.auth.destination.sendotp

import androidx.compose.runtime.Immutable

@Immutable
data class SendOtpUiState(
  val email: String,
  val isOtpSending: Boolean,
  val isAnonymousLoggingIn: Boolean,
  val isAnonymousSigningUp: Boolean,
  val isGoogleLoggingIn: Boolean,
  val isGoogleSigningUp: Boolean,
  val isHCaptchaVisible: Boolean,
) {
  companion object {
    val InitialValue = SendOtpUiState(
      email = "",
      isOtpSending = false,
      isAnonymousLoggingIn = false,
      isAnonymousSigningUp = false,
      isGoogleLoggingIn = false,
      isGoogleSigningUp = false,
      isHCaptchaVisible = false,
    )
  }
}
