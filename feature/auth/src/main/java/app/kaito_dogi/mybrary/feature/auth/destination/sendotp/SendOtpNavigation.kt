package app.kaito_dogi.mybrary.feature.auth.destination.sendotp

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.ui.navigation.route.AuthRoute

fun NavGraphBuilder.sendOtpScreen(
  onSendOtpComplete: (email: String, AuthRoute.VerifyOtp.Page) -> Unit,
  onLoginComplete: () -> Unit,
  onSignUpComplete: () -> Unit,
) {
  composable<AuthRoute.SendOtp> {
    SendOtpScreenContainer(
      onSendOtpComplete = onSendOtpComplete,
      onLoginComplete = onLoginComplete,
      onSignUpComplete = onSignUpComplete,
    )
  }
}
