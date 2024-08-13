package app.kaito_dogi.mybrary.feature.auth.route.verifyotp

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import app.kaito_dogi.mybrary.feature.auth.AuthRoute

fun NavGraphBuilder.verifyOtpScreen(
  onVerifyOtpComplete: () -> Unit,
) {
  composable<AuthRoute.VerifyOtp> { backStackEntry ->
    val email = backStackEntry.toRoute<AuthRoute.VerifyOtp>().email
    VerifyOtpScreenContainer(
      onVerifyOtpComplete = onVerifyOtpComplete,
    )
  }
}
