package app.kaito_dogi.mybrary.feature.auth.route.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.feature.auth.AuthRoute

fun NavGraphBuilder.loginScreen(
  onSendOtpComplete: (email: String) -> Unit,
  onLoginComplete: () -> Unit,
  onSignUpClick: () -> Unit,
) {
  composable<AuthRoute.Login> {
    LoginScreenContainer(
      onSendOtpComplete = onSendOtpComplete,
      onLoginComplete = onLoginComplete,
      onSignUpClick = onSignUpClick,
    )
  }
}
