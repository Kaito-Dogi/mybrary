package app.kaito_dogi.mybrary.feature.auth.destination.sendotp

import androidx.compose.runtime.Immutable

@Immutable
data class SendOtpUiState(
  val email: String,
  val isOtpSending: Boolean,
  val isLoggingInAsGuest: Boolean,
  val isLoggingInWithGoogle: Boolean,
  val isSigningUpAsGuest: Boolean,
  val isSigningUpWithGoogle: Boolean,
) {
  companion object {
    val InitialValue = SendOtpUiState(
      email = "",
      isOtpSending = false,
      isLoggingInAsGuest = false,
      isLoggingInWithGoogle = false,
      isSigningUpAsGuest = false,
      isSigningUpWithGoogle = false,
    )
  }
}
