package app.kaito_dogi.mybrary.feature.verifyotp

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import app.kaito_dogi.mybrary.core.common.model.CaptchaToken
import app.kaito_dogi.mybrary.core.ui.navigation.route.AuthRoute
import kotlin.reflect.typeOf
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val NavType.Companion.CaptchaTokenNavType
  get() = object : NavType<CaptchaToken>(isNullableAllowed = false) {
    override fun put(bundle: Bundle, key: String, value: CaptchaToken) {
      val encoded = Json.encodeToString(value)
      bundle.putString(key, encoded)
    }

    override fun get(bundle: Bundle, key: String): CaptchaToken? {
      val encoded = bundle.getString(key) ?: return null
      return Json.decodeFromString<CaptchaToken>(encoded)
    }

    override fun parseValue(value: String): CaptchaToken {
      return Json.decodeFromString<CaptchaToken>(
        Uri.decode(value),
      )
    }

    override fun serializeAsValue(value: CaptchaToken): String {
      return Uri.encode(
        Json.encodeToString(value),
      )
    }

    override val name: String = CaptchaToken::class.java.name
  }

internal val VerifyOtpTypeMap = mapOf(
  typeOf<AuthRoute.VerifyOtp.Source>() to NavType.EnumType(AuthRoute.VerifyOtp.Source::class.java),
  typeOf<CaptchaToken>() to NavType.CaptchaTokenNavType,
)
