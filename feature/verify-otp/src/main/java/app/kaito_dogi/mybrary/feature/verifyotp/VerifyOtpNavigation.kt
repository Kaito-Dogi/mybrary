package app.kaito_dogi.mybrary.feature.verifyotp

import android.net.Uri
import android.os.Bundle
import androidx.core.os.BundleCompat
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val VerifyOtp = "verify-otp"

internal const val VerifyOtpNavArgName = "${VerifyOtp}NavArg"

private const val VerifyOtpRoute = "${VerifyOtp}/${VerifyOtpNavArgName}"

private object VerifyOtpNavType : NavType<VerifyOtpNavArg>(
  isNullableAllowed = false,
) {
  override fun get(
    bundle: Bundle,
    key: String,
  ): VerifyOtpNavArg {
    return BundleCompat.getParcelable(bundle, key, VerifyOtpNavArg::class.java)!!
  }

  override fun parseValue(value: String): VerifyOtpNavArg {
    return Json.decodeFromString<VerifyOtpNavArg>(value)
  }

  override fun put(
    bundle: Bundle,
    key: String,
    value: VerifyOtpNavArg,
  ) {
    bundle.putParcelable(key, value)
  }
}

fun verifyOtpRouteWithNavArg(navArg: VerifyOtpNavArg) =
  "${VerifyOtp}/${Uri.encode(Json.encodeToString<VerifyOtpNavArg>(navArg))}"

fun NavGraphBuilder.verifyOtpScreen(
  onVerifyOtpComplete: () -> Unit,
) {
  composable(
    route = VerifyOtpRoute,
    arguments = listOf(
      navArgument(VerifyOtpNavArgName) {
        type = VerifyOtpNavType
      },
    ),
  ) {
    VerifyOtpScreenContainer(
      onVerifyOtpComplete = onVerifyOtpComplete,
    )
  }
}
