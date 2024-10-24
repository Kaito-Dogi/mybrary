package app.kaito_dogi.mybrary.feature.mybook.destination.mybookdetail

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import kotlin.reflect.typeOf
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val NavType.Companion.MyBookNavType
  get() = object : NavType<MyBook>(isNullableAllowed = false) {
    override fun put(bundle: Bundle, key: String, value: MyBook) {
      val encoded = Json.encodeToString(value)
      bundle.putString(key, encoded)
    }

    override fun get(bundle: Bundle, key: String): MyBook? {
      val encoded = bundle.getString(key) ?: return null
      return Json.decodeFromString<MyBook>(encoded)
    }

    override fun parseValue(value: String): MyBook {
      return Json.decodeFromString<MyBook>(
        Uri.decode(value),
      )
    }

    override fun serializeAsValue(value: MyBook): String {
      return Uri.encode(
        Json.encodeToString(value),
      )
    }

    override val name: String = MyBook::class.java.name
  }

internal val MyBookDetailTypeMap = mapOf(typeOf<MyBook>() to NavType.MyBookNavType)
