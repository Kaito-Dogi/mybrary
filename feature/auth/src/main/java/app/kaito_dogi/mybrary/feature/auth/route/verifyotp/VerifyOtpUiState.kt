package app.kaito_dogi.mybrary.feature.auth.route.verifyotp

import androidx.compose.runtime.Immutable

@Immutable
data class VerifyOtpUiState(
  val page: Page,
  val otp: String,
  val isOtpVerified: Boolean,
) {
  companion object {
    fun createInitialValue(
      page: Page,
    ) = VerifyOtpUiState(
      page = page,
      otp = "",
      isOtpVerified = false,
    )
  }

  enum class Page {
    Login,
    SignUp,
    ;
  }
}
