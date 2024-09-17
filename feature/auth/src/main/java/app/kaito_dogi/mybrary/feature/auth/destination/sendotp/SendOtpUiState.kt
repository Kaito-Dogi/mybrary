package app.kaito_dogi.mybrary.feature.auth.destination.sendotp

import androidx.compose.runtime.Immutable

@Immutable
data class SendOtpUiState(
  val email: String,
  val isOtpSending: Boolean,
  val isOtpSent: Boolean,
  val isLoggingIn: Boolean,
  val isLoggedIn: Boolean,
  val isSigningUp: Boolean,
  val isSignedUp: Boolean,
) {
  companion object {
    val InitialValue = SendOtpUiState(
      email = "",
      isOtpSending = false,
      isOtpSent = false,
      isLoggingIn = false,
      isLoggedIn = false,
      isSigningUp = false,
      isSignedUp = false,
    )
  }
}
