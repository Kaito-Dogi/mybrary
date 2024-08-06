package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
internal class VerifyOtpViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle,
) : ViewModel() {
  private val navArg: VerifyOtpNavArg = checkNotNull(savedStateHandle[VerifyOtpNavArgName])

  private val _uiState = MutableStateFlow(
    VerifyOtpUiState.createInitialValue(
      source = navArg.source,
    ),
  )
  val uiState = _uiState.asStateFlow()
}
