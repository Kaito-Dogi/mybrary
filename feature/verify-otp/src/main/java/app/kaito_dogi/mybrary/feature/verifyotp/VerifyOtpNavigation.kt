package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.ui.navigation.route.AuthRoute
import kotlin.reflect.typeOf

fun NavGraphBuilder.verifyOtpScreen(
  onVerifyOtpComplete: () -> Unit,
  onNavigationIconClick: () -> Unit,
) = composable<AuthRoute.VerifyOtp>(typeMap = VerifyOtpTypeMap) {
  VerifyOtpScreenContainer(
    onVerifyOtpComplete = onVerifyOtpComplete,
    onNavigationIconClick = onNavigationIconClick,
  )
}

fun NavHostController.navigateToVerifyOtpScreen(
  email: String,
  page: AuthRoute.VerifyOtp.Page,
) = this.navigate(
  route = AuthRoute.VerifyOtp(
    email = email,
    page = page,
  ),
)

internal val VerifyOtpTypeMap =
  mapOf(typeOf<AuthRoute.VerifyOtp.Page>() to NavType.EnumType(AuthRoute.VerifyOtp.Page::class.java))
