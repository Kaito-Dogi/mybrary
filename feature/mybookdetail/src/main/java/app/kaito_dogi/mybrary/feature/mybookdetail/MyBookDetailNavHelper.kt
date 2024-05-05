package app.kaito_dogi.mybrary.feature.mybookdetail

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object MyBookDetailNavHelper {
  private const val SCREEN_NAME = "myBookDetail"

  internal val navArgName = "${SCREEN_NAME.lowercase()}NavArgName"

  internal val navArgType = object : NavType<MyBookDetailNavArg>(
    isNullableAllowed = false,
  ) {
    override fun get(
      bundle: Bundle,
      key: String,
    ): MyBookDetailNavArg {
      return bundle.getParcelable(key)!!
    }

    override fun parseValue(value: String): MyBookDetailNavArg {
      return Json.decodeFromString<MyBookDetailNavArg>(value)
    }

    override fun put(
      bundle: Bundle,
      key: String,
      value: MyBookDetailNavArg,
    ) {
      bundle.putParcelable(key, value)
    }
  }

  internal val route = "${SCREEN_NAME.lowercase()}/{$navArgName}"

  fun routeWithNavArg(navArg: MyBookDetailNavArg): String {
    return "$SCREEN_NAME/${Uri.encode(Json.encodeToString<MyBookDetailNavArg>(navArg))}"
  }
}
