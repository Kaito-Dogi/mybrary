package app.kaito_dogi.mybrary.feature.mybookdetail

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val myBookDetail = "myBookDetail"

internal const val myBookDetailNavArgName = "${myBookDetail}NavArg"

private const val myBookDetailRoute = "${myBookDetail}/{${myBookDetailNavArgName}}"

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
  "${myBookDetail}/${Uri.encode(Json.encodeToString<MyBookDetailNavArg>(navArg))}"

fun NavGraphBuilder.myBookDetail(
  onBackClick: () -> Unit,
) {
  composable(
    route = myBookDetailRoute,
    arguments = listOf(
      navArgument(myBookDetailNavArgName) {
        type = MyBookDetailNavType
      },
    ),
  ) {
    MyBookDetailScreen(
      onBackClick = onBackClick,
    )
  }
}
