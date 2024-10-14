package app.kaito_dogi.mybrary.feature.auth.destination.sendotp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.common.coroutines.LaunchSafe
import app.kaito_dogi.mybrary.core.domain.model.HCaptchaToken
import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
internal class SendOtpViewModel @Inject constructor(
  private val authRepository: AuthRepository,
  launchSafe: LaunchSafe,
) : ViewModel(), LaunchSafe by launchSafe {
  private val _uiState = MutableStateFlow(SendOtpUiState.InitialValue)
  val uiState = _uiState.asStateFlow()

  private val _uiEvent = MutableSharedFlow<SendOtpUiEvent>()
  val uiEvent = _uiEvent.asSharedFlow()

  fun onEmailChange(email: String) {
    _uiState.update { it.copy(email = email) }
  }

  // FIXME: HCaptchaToken を受け取る
  fun onSendOtpClick() {
    viewModelScope.launchSafe {
      _uiState.update { it.copy(isOtpSending = true) }
      authRepository.sendOtp(
        email = uiState.value.email,
        captchaToken = HCaptchaToken(value = ""),
      )
      _uiEvent.emit(SendOtpUiEvent.IsOtpSent)
    }.invokeOnCompletion {
      _uiState.update { it.copy(isOtpSending = false) }
    }
  }

  fun onGoogleLoginClick() {
    println("あああ: onGoogleLoginClick")
  }

  // FIXME: 匿名ログインを共通化する
  fun onAnonymousLoginClick() {
    _uiState.update {
      it.copy(
        isAnonymousLoggingIn = true,
        isHCaptchaVisible = true,
      )
    }
  }

  fun onGoogleSignUpClick() {
    println("あああ: onGoogleSignUpClick")
  }

  // FIXME: 匿名ログインを共通化する
  fun onAnonymousSignUpClick() {
    _uiState.update {
      it.copy(
        isAnonymousSigningUp = true,
        isHCaptchaVisible = true,
      )
    }
  }

  fun onHCaptchaSuccess(hCaptchaToken: HCaptchaToken) {
    viewModelScope.launchSafe {
      _uiState.update { it.copy(isHCaptchaVisible = false) }
      // FIXME: 匿名ログインを共通化する
      when {
        uiState.value.isAnonymousLoggingIn -> {
          authRepository.anonymousSignIn(captchaToken = hCaptchaToken)
          _uiEvent.emit(SendOtpUiEvent.IsLoggedInAsGuest)
        }

        uiState.value.isAnonymousSigningUp -> {
          authRepository.anonymousSignIn(captchaToken = hCaptchaToken)
          _uiEvent.emit(SendOtpUiEvent.IsSignedUpAsGuest)
        }
      }
    }.invokeOnCompletion {
      _uiState.update {
        it.copy(
          isAnonymousLoggingIn = false,
          isAnonymousSigningUp = false,
        )
      }
    }
  }

  fun onHCaptchaFailure() {
    _uiState.update {
      it.copy(
        isAnonymousLoggingIn = false,
        isAnonymousSigningUp = false,
        isHCaptchaVisible = false,
      )
    }
  }

  // FIXME: 適切な実装に変更する
  val hasSessionFlow = MutableStateFlow(value = false)
  fun onInit() {
    viewModelScope.launchSafe {
      val session = authRepository.hasCurrentSession()
      hasSessionFlow.update { session }
    }
  }
}
