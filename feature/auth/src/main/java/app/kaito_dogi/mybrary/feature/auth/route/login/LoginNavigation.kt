package app.kaito_dogi.mybrary.feature.auth.route.login

import androidx.navigation.NavGraphBuilder

fun NavGraphBuilder.loginScreen(
  onSendOtpComplete: (email: String) -> Unit,
  onLoginComplete: () -> Unit,
  onSignUpClick: () -> Unit,
) {
//  composable<AuthRoute.Login> {
//    LoginScreenContainer(
//      onSendOtpComplete = onSendOtpComplete,
//      onLoginComplete = onLoginComplete,
//      onSignUpClick = onSignUpClick,
//    )
//  }
}
