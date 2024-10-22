package app.kaito_dogi.mybrary.feature.signin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.ui.navigation.route.AppRoute
import app.kaito_dogi.mybrary.core.ui.navigation.route.AuthRoute

fun NavGraphBuilder.signInScreen(
  onSendOtp: (email: String) -> Unit,
  onSignIn: () -> Unit,
) = composable<AuthRoute.SignIn> {
  SignInScreenContainer(
    onSendOtp = onSendOtp,
    onSignIn = onSignIn,
  )
}

fun NavHostController.navigateToSignInScreen() = this.navigate(route = AuthRoute.SignIn) {
  popUpTo<AppRoute.Main> {
    inclusive = true
  }
}
