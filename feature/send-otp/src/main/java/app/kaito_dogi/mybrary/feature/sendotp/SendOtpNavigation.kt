package app.kaito_dogi.mybrary.feature.sendotp

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.ui.navigation.MybraryRoute

fun NavGraphBuilder.sendOtpScreen(
  onSendOtpComplete: (email: String, MybraryRoute.VerifyOtp.Page) -> Unit,
  onLoginComplete: () -> Unit,
  onSignUpComplete: () -> Unit,
) {
  composable<MybraryRoute.SendOtp> {
    SendOtpScreenContainer(
      onSendOtpComplete = onSendOtpComplete,
      onLoginComplete = onLoginComplete,
      onSignUpComplete = onSignUpComplete,
    )
  }
}
