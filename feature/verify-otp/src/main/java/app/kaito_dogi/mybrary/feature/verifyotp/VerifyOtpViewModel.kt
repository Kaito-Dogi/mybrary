package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import app.kaito_dogi.mybrary.core.common.coroutines.LaunchSafe
import app.kaito_dogi.mybrary.core.domain.repository.OtpRepository
import app.kaito_dogi.mybrary.core.ui.navigation.MybraryRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
internal class VerifyOtpViewModel @Inject constructor(
  private val otpRepository: OtpRepository,
  savedStateHandle: SavedStateHandle,
  launchSafe: LaunchSafe,
) : ViewModel(), LaunchSafe by launchSafe {
  private val navArg: MybraryRoute.VerifyOtp = savedStateHandle.toRoute(typeMap = verifyOtpTypeMap)

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

  fun onVerifyOtpClick() {
    viewModelScope.launchSafe {
      _uiState.update { it.copy(isOtpVerifying = true) }

      otpRepository.verifyOtp(
        email = uiState.value.email,
        otp = uiState.value.otp,
      )

      _uiState.update { it.copy(isOtpVerified = true) }
    }.invokeOnCompletion {
      _uiState.update { it.copy(isOtpVerifying = false) }
    }
  }

  fun onResendOtpClick() {
    viewModelScope.launchSafe {
      _uiState.update { it.copy(isOtpResending = true) }
      otpRepository.sendOtp(
        email = uiState.value.email,
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
