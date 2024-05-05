package app.kaito_dogi.mybrary.feature.mybookdetail

import android.net.Uri
import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun myBookDetailRoute(
  arg: MyBookDetailNavArg,
): String = "myBookDetail/${Uri.encode(Json.encodeToString<MyBookDetailNavArg>(arg))}"

internal const val myBookDetailNavArgName = "myBookDetailNavArgName"
private const val myBookDetailRoute = "myBookDetail/{$myBookDetailNavArgName}"

private val NavType.Companion.MyBookDetailType: NavType<MyBookDetailNavArg>
  get() = object : NavType<MyBookDetailNavArg>(
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

fun NavGraphBuilder.myBookDetailScreen() {
  composable(
    route = myBookDetailRoute,
    arguments = listOf(
      navArgument(myBookDetailNavArgName) {
        type = NavType.MyBookDetailType
      },
    ),
  ) {
    MyBookDetailScreen()
  }
}

@Composable
private fun MyBookDetailScreen(
  viewModel: MyBookDetailViewModel = viewModel(),
) {
  MyBookDetailScreen(id = viewModel.arg.myBookId)
}

@Composable
private fun MyBookDetailScreen(
//  uiState
  id: MyBookId,
) {
  Scaffold { innerPadding ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding),
      contentAlignment = Alignment.Center,
    ) {
      Text(text = "MyBookDetail:${id.value}")
    }
  }
}

@Preview
@Composable
private fun MyBookDetailScreenPreview() {
  MybraryTheme {
    MyBookDetailScreen()
  }
}
