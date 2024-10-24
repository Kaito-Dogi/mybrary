package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.ui.navigation.route.AuthRoute
import kotlin.reflect.typeOf

fun NavGraphBuilder.verifyOtpScreen(
  onVerifyOtp: () -> Unit,
  onNavigationIconClick: () -> Unit,
) = composable<AuthRoute.VerifyOtp>(typeMap = VerifyOtpTypeMap) {
  VerifyOtpScreenContainer(
    onVerifyOtp = onVerifyOtp,
    onNavigationIconClick = onNavigationIconClick,
  )
}

fun NavHostController.navigateToVerifyOtpScreen(
  email: String,
  source: AuthRoute.VerifyOtp.Source,
) = this.navigate(
  route = AuthRoute.VerifyOtp(
    email = email,
    source = source,
  ),
)

internal val VerifyOtpTypeMap =
  mapOf(typeOf<AuthRoute.VerifyOtp.Source>() to NavType.EnumType(AuthRoute.VerifyOtp.Source::class.java))
