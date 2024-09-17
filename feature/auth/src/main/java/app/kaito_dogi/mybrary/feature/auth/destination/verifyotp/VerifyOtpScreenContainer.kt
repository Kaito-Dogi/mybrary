package app.kaito_dogi.mybrary.feature.auth.destination.verifyotp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun VerifyOtpScreenContainer(
  onVerifyOtpComplete: () -> Unit,
  onNavigationIconClick: () -> Unit,
  viewModel: VerifyOtpViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  if (uiState.isOtpVerified) {
    LaunchedEffect(Unit) {
      onVerifyOtpComplete()
      viewModel.onUiEventConsume()
    }
  }

  VerifyOtpScreen(
    uiState = uiState,
    onNavigationIconClick = onNavigationIconClick,
    onOtpChange = viewModel::onOtpChange,
    onVerifyOtpClick = viewModel::onVerifyOtpClick,
    onResendOtpClick = viewModel::onResendOtpClick,
  )
}
