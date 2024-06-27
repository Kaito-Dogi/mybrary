package app.kaito_dogi.mybrary.feature.searchbook

import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch

@Composable
internal fun SearchBookContainer(
  viewModel: SearchBookViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  val coroutineScope = rememberCoroutineScope()
  val snackbarHostState = remember { SnackbarHostState() }

  SearchBookScreen(
    uiState = uiState,
    snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
    showSnackbar = {
      coroutineScope.launch {
        snackbarHostState.showSnackbar(it)
        viewModel.onMessageShown()
      }
    },
    onSearchQueryChange = viewModel::onSearchQueryChange,
    onBarcodeScannerClick = {},
    // TODO: v2 以降で Click の実装を差し替える
    onSearchResultClick = viewModel::onSearchResultBookLongClick,
    onSearchResultLongClick = viewModel::onSearchResultBookLongClick,
  )
}
