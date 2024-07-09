package app.kaito_dogi.mybrary.feature.login

import androidx.compose.runtime.Immutable

@Immutable
data class LoginUiState(
  val email: String,
  val password: String,
  val isPasswordVisible: Boolean,
) {
  companion object {
    val InitialValue = LoginUiState(
      email = "",
      password = "",
      isPasswordVisible = false,
    )
  }
}
