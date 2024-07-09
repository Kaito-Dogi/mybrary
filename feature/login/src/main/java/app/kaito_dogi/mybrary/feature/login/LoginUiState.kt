package app.kaito_dogi.mybrary.feature.login

import androidx.compose.runtime.Immutable

@Immutable
data class LoginUiState(
  val mail: String,
  val password: String,
  val isPasswordVisible: Boolean,
) {
  companion object {
    val InitialValue = LoginUiState(
      mail = "",
      password = "",
      isPasswordVisible = false,
    )
  }
}
