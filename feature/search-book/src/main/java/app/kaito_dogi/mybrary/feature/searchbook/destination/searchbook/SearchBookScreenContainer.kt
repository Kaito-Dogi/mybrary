package app.kaito_dogi.mybrary.feature.searchbook.destination.searchbook

import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.kaito_dogi.mybrary.core.ui.browser.rememberExternalBrowserLauncher

@Composable
internal fun SearchBookScreenContainer(
  viewModel: SearchBookViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  val snackbarHostState = remember { SnackbarHostState() }
  val externalBrowserLauncher = rememberExternalBrowserLauncher()

  uiState.shownMessage?.let {
    LaunchedEffect(key1 = it) {
      snackbarHostState.showSnackbar(message = it)
      viewModel.onMessageShown()
    }
  }

  SearchBookScreen(
    uiState = uiState,
    snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
    onSearchQueryChange = viewModel::onSearchQueryChange,
    // TODO: v2 以降で Click の実装を差し替える
    onBookClick = viewModel::onBookLongClick,
    onBookLongClick = viewModel::onBookLongClick,
    onBookRakutenClick = { externalBrowserLauncher.launch(url = it.rakutenUrl) },
    onConfirmClick = viewModel::onConfirmClick,
    onDismissRequest = viewModel::onDismissClick,
  )
}
