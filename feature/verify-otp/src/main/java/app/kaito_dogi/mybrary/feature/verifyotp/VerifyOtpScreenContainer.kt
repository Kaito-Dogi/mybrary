package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun VerifyOtpScreenContainer(
  onVerifyOtpComplete: () -> Unit,
  viewModel: VerifyOtpViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  if (uiState.isOtpVerified) {
    LaunchedEffect(Unit) {
      onVerifyOtpComplete()
    }
  }

  VerifyOtpScreen(
    uiState = uiState,
    onOtpChange = viewModel::onOtpChange,
    onVerifyOtpClick = viewModel::onVerifyOtpClick,
  )
}
