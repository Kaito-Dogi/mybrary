package app.kaito_dogi.mybrary.feature.searchbook

import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun SearchBookScreenContainer(
  viewModel: SearchBooksViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  val snackbarHostState = remember { SnackbarHostState() }

  uiState.shownMessage?.let {
    LaunchedEffect(it) {
      snackbarHostState.showSnackbar(it)
      viewModel.onMessageShown()
    }
  }

  SearchBookScreen(
    uiState = uiState,
    snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
    onSearchQueryChange = viewModel::onSearchQueryChange,
    onBarcodeScannerClick = {},
    // TODO: v2 以降で Click の実装を差し替える
    onBookClick = viewModel::onBookLongClick,
    onBookLongClick = viewModel::onBookLongClick,
    onConfirmClick = viewModel::onConfirmClick,
    onDismissRequest = viewModel::onDismissClick,
  )
}
