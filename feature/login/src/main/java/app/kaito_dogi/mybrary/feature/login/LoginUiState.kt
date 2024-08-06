package app.kaito_dogi.mybrary.feature.login

import androidx.compose.runtime.Immutable

@Immutable
data class LoginUiState(
  val email: String,
  val isOneTimePasswordSent: Boolean,
  val isLoggedIn: Boolean,
) {
  companion object {
    val InitialValue = LoginUiState(
      email = "",
      isOneTimePasswordSent = false,
      isLoggedIn = false,
    )
  }
}
