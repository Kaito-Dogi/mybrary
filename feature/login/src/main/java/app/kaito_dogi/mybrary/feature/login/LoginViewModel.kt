package app.kaito_dogi.mybrary.feature.login

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

  fun onPasswordChange(password: String) {
    _uiState.update { it.copy(password = password) }
  }

  fun onVisibilityChange() {
    _uiState.update {
      it.copy(
        isPasswordVisible = !it.isPasswordVisible,
      )
    }
  }

  fun onMailLoginClick() {
    viewModelScope.launch {
      try {
        loginRepository.emailLogin(
          email = uiState.value.email,
          password = uiState.value.password,
        )
        _uiState.update { it.copy(isLoggedIn = true) }
      } catch (e: Exception) {
        // FIXME: 共通のエラーハンドリングを実装する
        println("あああ: ${e.message}")
      }
    }
  }

  fun onGoogleLoginClick() {
    println("あああ: onMailLoginClick")
  }
}
