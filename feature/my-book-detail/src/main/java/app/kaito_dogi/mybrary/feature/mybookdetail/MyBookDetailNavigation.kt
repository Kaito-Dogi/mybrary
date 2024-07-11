package app.kaito_dogi.mybrary.feature.mybookdetail

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val MyBookDetail = "myBookDetail"

internal const val MyBookDetailNavArgName = "${MyBookDetail}NavArg"

private const val MyBookDetailRoute = "${MyBookDetail}/{${MyBookDetailNavArgName}}"

private object MyBookDetailNavType : NavType<MyBookDetailNavArg>(
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

fun myBookDetailRouteWithNavArg(navArg: MyBookDetailNavArg) =
  "${MyBookDetail}/${Uri.encode(Json.encodeToString<MyBookDetailNavArg>(navArg))}"

fun NavGraphBuilder.myBookDetailScreen() {
  composable(
    route = MyBookDetailRoute,
    arguments = listOf(
      navArgument(MyBookDetailNavArgName) {
        type = MyBookDetailNavType
      },
    ),
  ) {
    MyBookDetailScreenContainer()
  }
}
