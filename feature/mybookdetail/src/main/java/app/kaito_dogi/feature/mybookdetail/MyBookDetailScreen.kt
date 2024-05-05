package app.kaito_dogi.feature.mybookdetail

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
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

fun NavGraphBuilder.myBookDetailScreen() {
  composable(
    route = "MyBookDetail",
  ) {
    MyBookDetailScreen()
  }
}

@Composable
private fun MyBookDetailScreen(
  viewModel: MyBookDetailViewModel = viewModel(),
) {
  MyBookDetailScreen(todo = "")
}

@Composable
private fun MyBookDetailScreen(
//  uiState
  todo: String,
) {
  Scaffold { innerPadding ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding),
      contentAlignment = Alignment.Center,
    ) {
      Text(text = "MyBookDetail")
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
