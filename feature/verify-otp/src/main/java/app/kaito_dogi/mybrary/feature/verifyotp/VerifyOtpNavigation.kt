package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.navigation.MybraryRoute
import kotlin.reflect.typeOf

fun NavGraphBuilder.verifyOtpScreen(
  onVerifyOtpComplete: () -> Unit,
) {
  composable<AuthRoute.VerifyOtp>(
    typeMap = mapOf(
      typeOf<VerifyOtpUiState.Page>() to NavType.EnumType(VerifyOtpUiState.Page::class.java),
    ),
  composable<MybraryRoute.VerifyOtp>(
  ) {
    VerifyOtpScreenContainer(
      onVerifyOtpComplete = onVerifyOtpComplete,
    )
  }
}
