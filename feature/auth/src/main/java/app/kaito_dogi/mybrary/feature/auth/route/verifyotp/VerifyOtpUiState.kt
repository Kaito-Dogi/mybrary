package app.kaito_dogi.mybrary.feature.auth.route.verifyotp

import androidx.compose.runtime.Immutable

@Immutable
data class VerifyOtpUiState(
//  val source: VerifyOtpNavArg.Source,
  val otp: String,
  val isOtpVerified: Boolean,
) {
  companion object {
    fun createInitialValue(
//      source: VerifyOtpNavArg.Source
    ) = VerifyOtpUiState(
//      source = source,
      otp = "",
      isOtpVerified = false,
    )
  }
}
