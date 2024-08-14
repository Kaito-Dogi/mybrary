package app.kaito_dogi.mybrary.feature.auth.route.signup

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.feature.auth.AuthRoute

fun NavGraphBuilder.signUpScreen(
  onSendOtpComplete: (email: String) -> Unit,
  onSignUpComplete: () -> Unit,
  onLoginClick: () -> Unit,
) {
  composable<AuthRoute.SignUp> {
    SignUpScreenContainer(
      onSendOtpComplete = onSendOtpComplete,
      onSignUpComplete = onSignUpComplete,
      onLoginClick = onLoginClick,
    )
  }
}
