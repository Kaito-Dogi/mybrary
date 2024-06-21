package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MyBookDetailScreen(
  viewModel: MyBookDetailViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  val coroutineScope = rememberCoroutineScope()
  val bottomSheetState = rememberModalBottomSheetState()

  LaunchedEffect(Unit) {
    viewModel.init()
  }

  MyBookDetailPage(
    uiState = uiState,
    bottomSheetState = bottomSheetState,
    onBackClick = {},
    onArchiveClick = viewModel::onArchiveClick,
    onFavoriteClick = viewModel::onFavoriteClick,
    onAdditionClick = viewModel::onAdditionClick,
    onMemoClick = viewModel::onMemoClick,
    onModalBottomSheetDismissRequest = viewModel::onBottomSheetDismissRequest,
    onFromPageChange = viewModel::onFromPageChange,
    onToPageChange = viewModel::onToPageChange,
    onContentChange = viewModel::onContentChange,
    onSaveClick = {
      coroutineScope.launch {
        viewModel.onSaveClick()
        bottomSheetState.hide()
      }.invokeOnCompletion {
        if (!bottomSheetState.isVisible) {
          viewModel.onBottomSheetDismissRequest()
        }
      }
    },
  )
}
