package app.kaito_dogi.mybrary.feature.auth.route.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun SignUpScreenContainer(
  onSendOtpComplete: (email: String) -> Unit,
  onSignUpComplete: () -> Unit,
  onLoginClick: () -> Unit,
  viewModel: SignUpViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  if (uiState.isSignedUp) {
    LaunchedEffect(Unit) {
      onSignUpComplete()
    }
  }

  if (uiState.isOtpSent) {
    LaunchedEffect(Unit) {
      onSendOtpComplete(uiState.email)
    }
  }

  SignUpScreen(
    uiState = uiState,
    onEmailChange = viewModel::onEmailChange,
    onSendOtpClick = viewModel::onSendOtpClick,
    onGoogleSignUpClick = viewModel::onGoogleSignUpClick,
    onLoginClick = onLoginClick,
  )
}
