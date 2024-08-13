package app.kaito_dogi.mybrary.feature.auth.route.verifyotp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.domain.repository.OtpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
internal class VerifyOtpViewModel @Inject constructor(
  private val otpRepository: OtpRepository,
  savedStateHandle: SavedStateHandle,
) : ViewModel() {
//  private val navArg: VerifyOtpNavArg = checkNotNull(savedStateHandle[VerifyOtpNavArgName])

  private val _uiState = MutableStateFlow(
    VerifyOtpUiState.createInitialValue(
//      source = navArg.source,
    ),
  )
  val uiState = _uiState.asStateFlow()

  fun onOtpChange(otp: String) {
    _uiState.update { it.copy(otp = otp) }
  }

  fun onVerifyOtpClick() {
    viewModelScope.launch {
      try {
        otpRepository.verifyOtp(
//          email = navArg.email,
          email = "",
          otp = uiState.value.otp,
        )
        _uiState.update { it.copy(isOtpVerified = true) }
      } catch (e: Exception) {
        // FIXME: 共通のエラーハンドリングを実装する
        println("あああ: ${e.message}")
      }
    }
  }
}
