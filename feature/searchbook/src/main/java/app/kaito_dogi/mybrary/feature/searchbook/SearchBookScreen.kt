package app.kaito_dogi.mybrary.feature.searchbook

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
internal fun SearchBookScreen(
  viewModel: SearchBookViewModel = viewModel(),
) {
  SearchBookPage()
}
