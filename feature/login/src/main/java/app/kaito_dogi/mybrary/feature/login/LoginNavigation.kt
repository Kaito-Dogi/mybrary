package app.kaito_dogi.mybrary.feature.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val Login = "login"

const val LoginRoute = Login

fun NavGraphBuilder.loginScreen(
  onSendOneTimePasswordComplete: () -> Unit,
  onLoginComplete: () -> Unit,
  onSignUpClick: () -> Unit,
) {
  composable(
    route = LoginRoute,
  ) {
    LoginScreenContainer(
      onSendOneTimePasswordComplete = onSendOneTimePasswordComplete,
      onLoginComplete = onLoginComplete,
      onSignUpClick = onSignUpClick,
    )
  }
}
