package app.kaito_dogi.mybrary.feature.searchbook

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun SearchBookContainer(
  viewModel: SearchBookViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  SearchBookScreen(
    uiState = uiState,
    onSearchQueryChange = viewModel::onSearchQueryChange,
    onBarcodeScannerClick = {},
  )
}
