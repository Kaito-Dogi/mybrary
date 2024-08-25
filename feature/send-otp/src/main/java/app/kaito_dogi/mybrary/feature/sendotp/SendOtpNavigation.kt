package app.kaito_dogi.mybrary.feature.sendotp

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.navigation.MybraryRoute

fun NavGraphBuilder.sendOtpScreen() {
  composable<MybraryRoute.SendOtp> {
    SendOtpScreenContainer()
  }
}
