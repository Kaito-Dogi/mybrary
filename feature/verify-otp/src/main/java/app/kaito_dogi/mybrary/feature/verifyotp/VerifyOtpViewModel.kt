package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import app.kaito_dogi.mybrary.core.common.coroutines.LaunchSafe
import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import app.kaito_dogi.mybrary.core.ui.navigation.route.AuthRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
internal class VerifyOtpViewModel @Inject constructor(
  private val authRepository: AuthRepository,
  savedStateHandle: SavedStateHandle,
  launchSafe: LaunchSafe,
) : ViewModel(), LaunchSafe by launchSafe {
  private val navArg: AuthRoute.VerifyOtp = savedStateHandle.toRoute(typeMap = VerifyOtpTypeMap)

  private val _uiState = MutableStateFlow(
    VerifyOtpUiState.createInitialValue(
      email = navArg.email,
      captchaToken = navArg.captchaToken,
      source = navArg.source,
    ),
  )
  val uiState = _uiState.asStateFlow()

  private val _uiEvent = MutableSharedFlow<VerifyOtpUiEvent>(extraBufferCapacity = 1)
  val uiEvent = _uiEvent.asSharedFlow()

  fun onOtpChange(otp: String) {
    _uiState.update { it.copy(otp = otp) }
  }

  // FIXME: HCaptchaToken を受け取る
  fun onVerifyOtpClick() {
    viewModelScope.launchSafe {
      _uiState.update { it.copy(isOtpVerifying = true) }

      authRepository.verifyOtp(
        email = uiState.value.email,
        otp = uiState.value.otp,
        captchaToken = uiState.value.captchaToken,
      )

      _uiEvent.tryEmit(VerifyOtpUiEvent.OnVerifyOtp)
    }.invokeOnCompletion {
      _uiState.update { it.copy(isOtpVerifying = false) }
    }
  }

  // FIXME: HCaptchaToken を受け取る
  // FIXME: auth.sendOtp ではなく auth.resendOtp にする
  fun onResendOtpClick() {
    viewModelScope.launchSafe {
      _uiState.update { it.copy(isOtpResending = true) }

      authRepository.otpSignUp(
        email = uiState.value.email,
        captchaToken = uiState.value.captchaToken,
      )

      _uiEvent.tryEmit(VerifyOtpUiEvent.OnResendOtp)
    }.invokeOnCompletion {
      _uiState.update { it.copy(isOtpResending = false) }
    }
  }
}
