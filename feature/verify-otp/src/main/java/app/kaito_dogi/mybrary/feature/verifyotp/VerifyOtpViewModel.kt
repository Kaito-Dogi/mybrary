package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import app.kaito_dogi.mybrary.core.navigation.MybraryRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
internal class VerifyOtpViewModel @Inject constructor(
  private val authRepository: AuthRepository,
  savedStateHandle: SavedStateHandle,
) : ViewModel() {
  private val navArg: MybraryRoute.VerifyOtp = savedStateHandle.toRoute(typeMap = verifyOtpTypeMap)

  private val _uiState = MutableStateFlow(
    VerifyOtpUiState.createInitialValue(
      page = navArg.page,
    ),
  )
  val uiState = _uiState.asStateFlow()

  fun onOtpChange(otp: String) {
    _uiState.update { it.copy(otp = otp) }
  }

  fun onVerifyOtpClick() {
    viewModelScope.launch {
      try {
        _uiState.update { it.copy(isOtpVerifying = true) }

        authRepository.verifyOtp(
          email = navArg.email,
          otp = uiState.value.otp,
        )

        _uiState.update { it.copy(isOtpVerified = true) }
      } catch (e: Exception) {
        // FIXME: 共通のエラーハンドリングを実装する
        println("あああ: ${e.message}")
      } finally {
        _uiState.update { it.copy(isOtpVerifying = false) }
      }
    }
  }
}
