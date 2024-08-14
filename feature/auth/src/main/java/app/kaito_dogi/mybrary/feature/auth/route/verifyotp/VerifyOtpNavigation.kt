package app.kaito_dogi.mybrary.feature.auth.route.verifyotp

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.feature.auth.AuthRoute
import kotlin.reflect.typeOf

fun NavGraphBuilder.verifyOtpScreen(
  onVerifyOtpComplete: () -> Unit,
) {
  composable<AuthRoute.VerifyOtp>(
    typeMap = mapOf(
      typeOf<VerifyOtpUiState.Page>() to NavType.EnumType(VerifyOtpUiState.Page::class.java),
    ),
  ) {
    VerifyOtpScreenContainer(
      onVerifyOtpComplete = onVerifyOtpComplete,
    )
  }
}
