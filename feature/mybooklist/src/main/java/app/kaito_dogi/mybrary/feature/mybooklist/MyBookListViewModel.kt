package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
internal class MyBookListViewModel @Inject constructor() : ViewModel() {
  private val _uiState = MutableStateFlow(MyBookListUiState.initialValue)
  val uiState = _uiState.asStateFlow()
}
