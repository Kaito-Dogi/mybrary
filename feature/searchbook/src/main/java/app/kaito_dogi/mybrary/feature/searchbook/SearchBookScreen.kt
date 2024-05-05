package app.kaito_dogi.mybrary.feature.searchbook

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

const val searchBookRoute = "searchBook"

fun NavGraphBuilder.searchBookScreen() {
  composable(
    route = searchBookRoute,
  ) {
    SearchBookScreen()
  }
}

@Composable
private fun SearchBookScreen(
    viewModel: SearchBookViewModel = viewModel(),
) {
  SearchBookScreen(todo = "")
}

@Composable
private fun SearchBookScreen(
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
      Text(text = "SearchBook")
    }
  }
}

@Preview
@Composable
private fun SearchBookScreenPreview() {
  MybraryTheme {
    SearchBookScreen()
  }
}
