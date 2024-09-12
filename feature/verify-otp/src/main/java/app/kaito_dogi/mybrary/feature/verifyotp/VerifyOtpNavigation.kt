package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.ui.navigation.MybraryRoute
import kotlin.reflect.typeOf

internal val verifyOtpTypeMap = mapOf(
  typeOf<MybraryRoute.VerifyOtp.Page>() to NavType.EnumType(MybraryRoute.VerifyOtp.Page::class.java),
)

fun NavGraphBuilder.verifyOtpScreen(
  onVerifyOtpComplete: () -> Unit,
  onNavigationIconClick: () -> Unit,
) {
  composable<MybraryRoute.VerifyOtp>(
    typeMap = verifyOtpTypeMap,
  ) {
    VerifyOtpScreenContainer(
      onVerifyOtpComplete = onVerifyOtpComplete,
      onNavigationIconClick = onNavigationIconClick,
    )
  }
}
