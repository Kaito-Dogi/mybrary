package app.kaito_dogi.mybrary.feature.auth.destination.sendotp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.common.coroutines.LaunchSafe
import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import app.kaito_dogi.mybrary.core.domain.repository.OtpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
internal class SendOtpViewModel @Inject constructor(
  private val otpRepository: OtpRepository,
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

  fun onSendOtpClick() {
    viewModelScope.launchSafe {
      _uiState.update { it.copy(isOtpSending = true) }
      otpRepository.sendOtp(
        email = uiState.value.email,
      )
      _uiEvent.tryEmit(SendOtpUiEvent.IsOtpSent)
    }.invokeOnCompletion {
      _uiState.update { it.copy(isOtpSending = false) }
    }
  }

  fun onGoogleLoginClick() {
    println("あああ: onGoogleLoginClick")
  }

  fun onAnonymousLoginClick() {
    viewModelScope.launchSafe {
      _uiState.update { it.copy(isLoggingInAsGuest = true) }
      delay(1_000L)
      _uiEvent.emit(SendOtpUiEvent.IsLoggedInAsGuest)
    }.invokeOnCompletion {
      _uiState.update { it.copy(isLoggingInWithGoogle = false) }
    }
  }

  fun onGoogleSignUpClick() {
    println("あああ: onGoogleSignUpClick")
  }

  fun onAnonymousSignUpClick() {
    viewModelScope.launchSafe {
      _uiState.update { it.copy(isSigningUpAsGuest = true) }
      delay(1_000L)
      _uiEvent.emit(SendOtpUiEvent.IsSignedUpAsGuest)
    }.invokeOnCompletion {
      _uiState.update { it.copy(isSigningUpAsGuest = false) }
    }
  }

  // FIXME: 適切な実装に変更する
  val hasSessionFlow = MutableStateFlow(value = false)
  fun onInit() {
    viewModelScope.launchSafe {
      val session = authRepository.hasSession()
      hasSessionFlow.update { session }
    }
  }
}
