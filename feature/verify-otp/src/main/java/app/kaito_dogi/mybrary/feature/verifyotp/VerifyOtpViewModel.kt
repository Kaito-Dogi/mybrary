package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import app.kaito_dogi.mybrary.core.common.coroutines.LaunchSafe
import app.kaito_dogi.mybrary.core.common.model.CaptchaToken
import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import app.kaito_dogi.mybrary.core.ui.navigation.route.AuthRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
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
      page = navArg.page,
    ),
  )
  val uiState = _uiState.asStateFlow()

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
        captchaToken = CaptchaToken(value = ""),
      )

      _uiState.update { it.copy(isOtpVerified = true) }
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
        captchaToken = CaptchaToken(value = ""),
      )
      _uiState.update { it.copy(isOtpResent = true) }
    }.invokeOnCompletion {
      _uiState.update { it.copy(isOtpResending = false) }
    }
  }

  fun onUiEventConsume() {
    _uiState.update { it.copy(isOtpVerified = false) }
  }
}
