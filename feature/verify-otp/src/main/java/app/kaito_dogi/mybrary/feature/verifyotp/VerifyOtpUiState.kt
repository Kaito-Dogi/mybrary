package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.compose.runtime.Immutable

@Immutable
data class VerifyOtpUiState(
  val source: VerifyOtpSource,
  val otp: String,
  val isOtpVerified: Boolean,
) {
  companion object {
    fun createInitialValue(source: VerifyOtpSource) = VerifyOtpUiState(
      source = source,
      otp = "",
      isOtpVerified = false,
    )
  }
}
