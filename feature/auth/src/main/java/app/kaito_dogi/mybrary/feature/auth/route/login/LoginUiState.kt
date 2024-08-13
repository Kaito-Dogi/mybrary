package app.kaito_dogi.mybrary.feature.auth.route.login

import androidx.compose.runtime.Immutable

@Immutable
data class LoginUiState(
  val email: String,
  val isOtpSent: Boolean,
  val isLoggedIn: Boolean,
) {
  companion object {
    val InitialValue = LoginUiState(
      email = "",
      isOtpSent = false,
      isLoggedIn = false,
    )
  }
}
