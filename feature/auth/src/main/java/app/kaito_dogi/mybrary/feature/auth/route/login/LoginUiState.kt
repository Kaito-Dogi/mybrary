package app.kaito_dogi.mybrary.feature.auth.route.login

import androidx.compose.runtime.Immutable

@Immutable
data class LoginUiState(
  val email: String,
  val isOtpSending: Boolean,
  val isOtpSent: Boolean,
  val isLoggingIn: Boolean,
  val isLoggedIn: Boolean,
) {
  companion object {
    val InitialValue = LoginUiState(
      email = "",
      isOtpSending = false,
      isOtpSent = false,
      isLoggingIn = false,
      isLoggedIn = false,
    )
  }
}
