package app.kaito_dogi.mybrary.feature.sendotp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import app.kaito_dogi.mybrary.core.domain.repository.OtpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
internal class SendOtpViewModel @Inject constructor(
  private val otpRepository: OtpRepository,
  private val authRepository: AuthRepository,
) : ViewModel() {
  private val _uiState = MutableStateFlow(SendOtpUiState.InitialValue)
  val uiState = _uiState.asStateFlow()

  fun onEmailChange(email: String) {
    _uiState.update { it.copy(email = email) }
  }

  fun onSendOtpClick() {
    viewModelScope.launch {
      try {
        _uiState.update { it.copy(isOtpSending = true) }
        otpRepository.sendOtp(
          email = uiState.value.email,
        )
        _uiState.update { it.copy(isOtpSent = true) }
      } catch (e: Exception) {
        // FIXME: 共通のエラーハンドリングを実装する
        println("あああ: ${e.message}")
      } finally {
        _uiState.update { it.copy(isOtpSending = false) }
      }
    }
  }

  fun onGoogleLoginClick() {
    println("あああ: onGoogleLoginClick")
  }

  fun onGoogleSignUpClick() {
    println("あああ: onGoogleSignUpClick")
  }

  // FIXME: UI Event の定義を考える
  fun onUiEventConsume() {
    _uiState.update {
      it.copy(
        isOtpSent = false,
        isLoggedIn = false,
        isSignedUp = false,
      )
    }
  }

  // FIXME: 適切な実装に変更する
  val hasSessionFlow = MutableStateFlow(value = false)
  fun onInit() {
    viewModelScope.launch {
      try {
        val session = authRepository.hasSession()
        hasSessionFlow.update { session }
      } catch (e: Exception) {
        // FIXME: 共通のエラーハンドリングを実装する
        println("あああ: ${e.message}")
      }
    }
  }
}
