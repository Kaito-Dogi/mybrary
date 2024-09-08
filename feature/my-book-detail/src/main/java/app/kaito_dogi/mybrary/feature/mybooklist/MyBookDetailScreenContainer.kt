package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.kaito_dogi.mybrary.core.designsystem.component.FullScrimModalBottomSheet
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MyBookDetailScreenContainer(
  viewModel: MyBookDetailViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  val snackbarHostState = remember { SnackbarHostState() }
  val bottomSheetState = rememberModalBottomSheetState()

  LaunchedEffect(Unit) {
    viewModel.onInit()
  }

  uiState.messageResId?.let {
    val context = LocalContext.current
    LaunchedEffect(it) {
      snackbarHostState.showSnackbar(context.getString(it))
      viewModel.onMessageShow()
    }
  }

  if (uiState.isMemoSaved) {
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
      coroutineScope.launch {
        bottomSheetState.hide()
      }.invokeOnCompletion {
        if (!bottomSheetState.isVisible) {
          viewModel.onBottomSheetDismissRequest()
        }
      }
    }
  }

  MyBookDetailScreen(
    uiState = uiState,
    snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
    bottomSheet = {
      FullScrimModalBottomSheet(
        onDismissRequest = viewModel::onBottomSheetDismissRequest,
        sheetState = bottomSheetState,
        content = it,
      )
    },
    onArchiveClick = viewModel::onArchiveClick,
    onPublicClick = viewModel::onPublicClick,
    onFavoriteClick = viewModel::onFavoriteClick,
    onAdditionClick = viewModel::onAdditionClick,
    onMemoClick = viewModel::onMemoClick,
    onStartPageChange = viewModel::onStartPageChange,
    onEndPageChange = viewModel::onEndPageChange,
    onContentChange = viewModel::onContentChange,
    onSaveClick = viewModel::onSaveClick,
  )
}
