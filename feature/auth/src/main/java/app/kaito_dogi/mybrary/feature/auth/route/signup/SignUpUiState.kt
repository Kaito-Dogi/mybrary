package app.kaito_dogi.mybrary.feature.auth.route.signup

import androidx.compose.runtime.Immutable

@Immutable
data class SignUpUiState(
  val email: String,
  val isOtpSending: Boolean,
  val isOtpSent: Boolean,
  val isSigningUp: Boolean,
  val isSignedUp: Boolean,
) {
  companion object {
    val InitialValue = SignUpUiState(
      email = "",
      isOtpSending = false,
      isOtpSent = false,
      isSigningUp = false,
      isSignedUp = false,
    )
  }
}
