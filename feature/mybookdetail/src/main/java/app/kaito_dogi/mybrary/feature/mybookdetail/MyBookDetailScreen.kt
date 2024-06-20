package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun MyBookDetailScreen(
  viewModel: MyBookDetailViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  LaunchedEffect(Unit) {
    viewModel.init()
  }

  MyBookDetailPage(
    uiState = uiState,
    onBackClick = {},
    onArchiveClick = viewModel::onArchiveClick,
    onFavoriteClick = viewModel::onFavoriteClick,
    onEditClick = {},
  )
}
