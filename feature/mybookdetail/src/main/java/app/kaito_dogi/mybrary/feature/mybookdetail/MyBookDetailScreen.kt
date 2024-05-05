package app.kaito_dogi.mybrary.feature.mybookdetail

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
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.MyBookId

fun NavGraphBuilder.myBookDetailScreen() {
  composable(
    route = MyBookDetailNavHelper.route,
    arguments = listOf(
      navArgument(MyBookDetailNavHelper.navArgName) {
        type = MyBookDetailNavHelper.navArgType
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
  MyBookDetailScreen(id = viewModel.navArg.myBookId)
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