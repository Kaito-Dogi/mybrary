package app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.kaito_dogi.mybrary.core.domain.model.MyBook

@Composable
internal fun MyBookListScreenContainer(
  onAdditionClick: () -> Unit,
  onMyBookClick: (MyBook) -> Unit,
  viewModel: MyBookListViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  LaunchedEffect(Unit) {
    viewModel.onInit()
  }

  MyBookListScreen(
    uiState = uiState,
    onAdditionClick = onAdditionClick,
    onMyBookClick = onMyBookClick,
  )
}
