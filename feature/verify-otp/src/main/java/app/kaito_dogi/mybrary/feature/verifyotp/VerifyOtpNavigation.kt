package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val VerifyOtp = "verify-otp"

const val VerifyOtpRoute = VerifyOtp

fun NavGraphBuilder.verifyOtpScreen(
  onVerifyOtpComplete: () -> Unit,
) {
  composable(
    route = VerifyOtpRoute,
  ) {
    VerifyOtpScreenContainer(
      onVerifyOtpComplete = onVerifyOtpComplete,
    )
  }
}
