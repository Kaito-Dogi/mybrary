package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
internal class MyBookDetailViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle,
) : ViewModel() {
  private val navArg: MyBookDetailNavArg =
    checkNotNull(savedStateHandle[MyBookDetailNavHelper.navArgName])

  private val _uiState = MutableStateFlow(MyBookDetailUiState.createInitialValue(navArg.myBook))
  val uiState = _uiState.asStateFlow()
}
