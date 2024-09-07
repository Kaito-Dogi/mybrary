package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.ui.navigation.MybraryRoute

@Immutable
internal data class VerifyOtpUiState(
  val page: MybraryRoute.VerifyOtp.Page,
  val otp: String,
  val isOtpVerifying: Boolean,
  val isOtpVerified: Boolean,
) {
  companion object {
    fun createInitialValue(
      page: MybraryRoute.VerifyOtp.Page,
    ) = VerifyOtpUiState(
      page = page,
      otp = "",
      isOtpVerifying = false,
      isOtpVerified = false,
    )
  }
}
