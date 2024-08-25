package app.kaito_dogi.mybrary.feature.auth.route.signup

import androidx.navigation.NavGraphBuilder

fun NavGraphBuilder.signUpScreen(
  onSendOtpComplete: (email: String) -> Unit,
  onSignUpComplete: () -> Unit,
  onLoginClick: () -> Unit,
) {
//  composable<AuthRoute.SignUp> {
//    SignUpScreenContainer(
//      onSendOtpComplete = onSendOtpComplete,
//      onSignUpComplete = onSignUpComplete,
//      onLoginClick = onLoginClick,
//    )
//  }
}
