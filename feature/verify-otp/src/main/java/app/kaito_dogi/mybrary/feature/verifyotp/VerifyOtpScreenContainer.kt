package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun VerifyOtpScreenContainer(
  onVerifyOtpComplete: () -> Unit,
  viewModel: VerifyOtpViewModel = hiltViewModel(),
) {
//  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  VerifyOtpScreen(
    otp = "",
    onOtpChange = {},
    onLoginClick = {},
    onSignUpClick = {},
  )
}
