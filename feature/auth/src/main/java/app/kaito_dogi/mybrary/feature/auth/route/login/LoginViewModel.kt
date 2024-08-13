package app.kaito_dogi.mybrary.feature.auth.route.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.domain.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
internal class LoginViewModel @Inject constructor(
  private val loginRepository: LoginRepository,
) : ViewModel() {
  private val _uiState = MutableStateFlow(LoginUiState.InitialValue)
  val uiState = _uiState.asStateFlow()

  fun onEmailChange(email: String) {
    _uiState.update { it.copy(email = email) }
  }

  fun onSendOtpClick() {
    viewModelScope.launch {
      try {
        loginRepository.sendOtp(
          email = uiState.value.email,
        )
        _uiState.update { it.copy(isOtpSent = true) }
      } catch (e: Exception) {
        // FIXME: 共通のエラーハンドリングを実装する
        println("あああ: ${e.message}")
      }
    }
  }

  fun onGoogleLoginClick() {
    println("あああ: onGoogleLoginClick")
  }
}
