package app.kaito_dogi.mybrary.feature.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.common.coroutines.LaunchSafe
import app.kaito_dogi.mybrary.core.common.model.CaptchaToken
import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
internal class SignInViewModel @Inject constructor(
  private val authRepository: AuthRepository,
  launchSafe: LaunchSafe,
) : ViewModel(), LaunchSafe by launchSafe {
  private val _uiState = MutableStateFlow(SignInUiState.InitialValue)
  val uiState = _uiState.asStateFlow()

  private val _uiEvent = MutableSharedFlow<SignInUiEvent>(extraBufferCapacity = 1)
  val uiEvent = _uiEvent.asSharedFlow()

  fun onEmailChange(email: String) {
    _uiState.update { it.copy(email = email) }
  }

  fun onSendOtpClick() {
    _uiState.update {
      it.copy(isOtpSending = true)
    }
  }

  fun onGoogleSignInClick() {
    println("あああ: onGoogleSignInClick")
  }

  fun onHCaptchaSuccess(captchaToken: CaptchaToken) {
    viewModelScope.launchSafe {
      authRepository.otpSignIn(
        email = uiState.value.email,
        captchaToken = captchaToken,
      )
      _uiEvent.tryEmit(SignInUiEvent.OnOtpSend)
    }.invokeOnCompletion {
      _uiState.update {
        it.copy(isOtpSending = false)
      }
    }
  }

  fun onHCaptchaFailure() {
    _uiState.update {
      it.copy(isOtpSending = false)
    }
  }
}
