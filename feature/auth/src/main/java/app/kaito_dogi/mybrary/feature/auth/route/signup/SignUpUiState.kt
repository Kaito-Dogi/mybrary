package app.kaito_dogi.mybrary.feature.auth.route.signup

import androidx.compose.runtime.Immutable

@Immutable
data class SignUpUiState(
  val email: String,
  val isOtpSent: Boolean,
  val isSignedUp: Boolean,
) {
  companion object {
    val InitialValue = SignUpUiState(
      email = "",
      isOtpSent = false,
      isSignedUp = false,
    )
  }
}
