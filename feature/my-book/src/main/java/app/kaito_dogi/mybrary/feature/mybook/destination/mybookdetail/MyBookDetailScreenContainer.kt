package app.kaito_dogi.mybrary.feature.mybook.destination.mybookdetail

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
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.kaito_dogi.mybrary.core.designsystem.component.FullScrimModalBottomSheet
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.Sns
import app.kaito_dogi.mybrary.core.ui.browser.rememberExternalBrowserLauncher
import app.kaito_dogi.mybrary.core.ui.sns.shareTextToX
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MyBookDetailScreenContainer(
  myBook: MyBook,
  onNavigationIconClick: () -> Unit,
  viewModel: MyBookDetailViewModel = hiltViewModel<MyBookDetailViewModel, MyBookDetailViewModel.Factory>(
    creationCallback = { factory -> factory.create(initialMyBook = myBook) },
  ),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  val snackbarHostState = remember { SnackbarHostState() }
  val bottomSheetState = rememberModalBottomSheetState()
  val externalBrowserLauncher = rememberExternalBrowserLauncher()

  LaunchedEffect(key1 = Unit) {
    viewModel.onInit()
  }

  uiState.messageResId?.let {
    val context = LocalContext.current
    LaunchedEffect(key1 = it) {
      snackbarHostState.showSnackbar(message = context.getString(it))
      viewModel.onMessageShow()
    }
  }

  uiState.shareTextToSns?.let { shareTextToSns ->
    val (shareText, sns) = shareTextToSns
    val context = LocalContext.current
    LaunchedEffect(key1 = shareTextToSns) {
      when (sns) {
        Sns.X ->  context.shareTextToX(text = shareText)
      }
      viewModel.onTextShared()
    }
  }

  if (uiState.isMemoSaved) {
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = Unit) {
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
    onNavigationIconClick = onNavigationIconClick,
    onFavoriteClick = viewModel::onFavoriteClick,
    onRakutenClick = { externalBrowserLauncher.launch(url = uiState.myBook.rakutenUrl) },
    onAdditionClick = viewModel::onAdditionClick,
    onMemoClick = viewModel::onMemoClick,
    onShareTextToXClick = viewModel::onShareTextToXClick,
    onStartPageChange = viewModel::onStartPageChange,
    onEndPageChange = viewModel::onEndPageChange,
    onContentChange = viewModel::onContentChange,
    onSaveClick = viewModel::onSaveClick,
  )
}
