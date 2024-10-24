package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.common.model.CaptchaToken
import app.kaito_dogi.mybrary.core.ui.navigation.route.AuthRoute

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
  captchaToken: CaptchaToken,
  source: AuthRoute.VerifyOtp.Source,
) = this.navigate(
  route = AuthRoute.VerifyOtp(
    email = email,
    captchaToken = captchaToken,
    source = source,
  ),
)
