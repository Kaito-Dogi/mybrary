package app.kaito_dogi.mybrary.feature.signup

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.ui.navigation.route.AppRoute
import app.kaito_dogi.mybrary.core.ui.navigation.route.AuthRoute

fun NavGraphBuilder.signUpScreen() = composable<AuthRoute.SignUp> {
  SignUpScreenContainer()
}

fun NavHostController.navigateToSignUpScreen() = this.navigate(route = AuthRoute.SignUp) {
  popUpTo<AppRoute.Main> {
    inclusive = true
  }
}
