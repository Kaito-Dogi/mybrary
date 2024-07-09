package app.kaito_dogi.mybrary.feature.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
internal class LoginViewModel @Inject constructor() : ViewModel() {
  private val _uiState = MutableStateFlow(LoginUiState.InitialValue)
  val uiState = _uiState.asStateFlow()

  fun onMailChange(mail: String) {
    _uiState.update {
      it.copy(
        mail = mail,
      )
    }
  }

  fun onPasswordChange(password: String) {
    _uiState.update {
      it.copy(
        password = password,
      )
    }
  }

  fun onVisibilityChange() {
    _uiState.update {
      it.copy(
        isPasswordVisible = !it.isPasswordVisible,
      )
    }
  }

  fun onMailLoginClick() {
    println("あああ: onMailLoginClick")
  }

  fun onGoogleLoginClick() {
    println("あああ: onMailLoginClick")
  }
}
