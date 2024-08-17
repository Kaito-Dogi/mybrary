package app.kaito_dogi.mybrary.core.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import java.io.Serializable
import kotlin.reflect.KType
import kotlin.reflect.typeOf
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

inline fun <reified T : Serializable> createTypePair(): Pair<KType, NavType<T>> {
  val navType = object : NavType<T>(isNullableAllowed = false) {
    override fun put(bundle: Bundle, key: String, value: T) {
      val encoded = Json.encodeToString(value)
      bundle.putString(key, encoded)
    }

    override fun get(bundle: Bundle, key: String): T? {
      val encoded = bundle.getString(key) ?: return null
      return Json.decodeFromString<T>(encoded)
    }

    override fun parseValue(value: String): T {
      return Json.decodeFromString<T>(
        Uri.decode(value),
      )
    }

    override fun serializeAsValue(value: T): String {
      return Uri.encode(
        Json.encodeToString(value),
      )
    }

    override val name: String = (T::class.java).name
  }

  return typeOf<T>() to navType
}
