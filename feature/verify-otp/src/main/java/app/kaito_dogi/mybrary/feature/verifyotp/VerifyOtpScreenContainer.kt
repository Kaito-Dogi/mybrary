package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
internal fun VerifyOtpScreenContainer(
  onVerifyOtp: () -> Unit,
  onNavigationIconClick: () -> Unit,
  viewModel: VerifyOtpViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  val lifecycleOwner = LocalLifecycleOwner.current
  LaunchedEffect(viewModel, lifecycleOwner) {
    viewModel.uiEvent
      .flowWithLifecycle(lifecycleOwner.lifecycle)
      .onEach { uiEvent ->
        when (uiEvent) {
          VerifyOtpUiEvent.OnVerifyOtp -> onVerifyOtp()
          VerifyOtpUiEvent.OnResendOtp -> Unit // FIXME: 実装する
        }
      }
      .launchIn(scope = this)
  }

  VerifyOtpScreen(
    uiState = uiState,
    onNavigationIconClick = onNavigationIconClick,
    onOtpChange = viewModel::onOtpChange,
    onVerifyOtpClick = viewModel::onVerifyOtpClick,
    onResendOtpClick = viewModel::onResendOtpClick,
  )
}
