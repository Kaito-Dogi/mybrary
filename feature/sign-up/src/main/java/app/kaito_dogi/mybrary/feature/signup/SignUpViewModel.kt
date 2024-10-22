package app.kaito_dogi.mybrary.feature.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.common.coroutines.LaunchSafe
import app.kaito_dogi.mybrary.core.common.model.CaptchaToken
import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
internal class SignUpViewModel @Inject constructor(
  private val authRepository: AuthRepository,
  launchSafe: LaunchSafe,
) : ViewModel(), LaunchSafe by launchSafe {
  private val _uiState = MutableStateFlow(SignUpUiState.InitialValue)
  val uiState = _uiState.asStateFlow()

  private val _uiEvent = MutableSharedFlow<SignUpUiEvent>(
    replay = 1,
    onBufferOverflow = BufferOverflow.DROP_OLDEST,
  )
  val uiEvent = _uiEvent.asSharedFlow()

  fun onEmailChange(email: String) {
    _uiState.update { it.copy(email = email) }
  }

  fun onSendOtpClick() {
    _uiState.update {
      it.copy(isOtpSending = true)
    }
  }

  fun onGoogleSignUpClick() {
    println("あああ: onGoogleSignUpClick")
  }

  fun onAnonymousSignUpClick() {
    _uiState.update {
      it.copy(isAnonymousSigningUp = true)
    }
  }

  fun onHCaptchaSuccess(captchaToken: CaptchaToken) {
    viewModelScope.launchSafe {
      when {
        uiState.value.isOtpSending -> {
          authRepository.sendOtp(
            email = uiState.value.email,
            captchaToken = captchaToken,
          )
          _uiEvent.tryEmit(SignUpUiEvent.OnSendOtp)
        }

        uiState.value.isAnonymousSigningUp -> {
          authRepository.anonymousSignIn(captchaToken = captchaToken)
          _uiEvent.tryEmit(SignUpUiEvent.OnAnonymousSignUp)
        }
      }
    }.invokeOnCompletion {
      _uiState.update {
        it.copy(
          isOtpSending = false,
          isAnonymousSigningUp = false,
        )
      }
    }
  }

  fun onHCaptchaFailure() {
    _uiState.update {
      it.copy(
        isOtpSending = false,
        isAnonymousSigningUp = false,
      )
    }
  }
}
