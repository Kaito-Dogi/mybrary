package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
internal fun MyBookDetailScreen(
  viewModel: MyBookDetailViewModel = viewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  MyBookDetailPage(
    uiState = uiState,
  )
}
