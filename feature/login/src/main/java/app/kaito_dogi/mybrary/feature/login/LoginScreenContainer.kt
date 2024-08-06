package app.kaito_dogi.mybrary.feature.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun LoginScreenContainer(
  onSendOneTimePasswordComplete: () -> Unit,
  onLoginComplete: () -> Unit,
  onSignUpClick: () -> Unit,
  viewModel: LoginViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  if (uiState.isLoggedIn) {
    LaunchedEffect(Unit) {
      onLoginComplete()
    }
  }

  if (uiState.isOneTimePasswordSent) {
    LaunchedEffect(Unit) {
      onSendOneTimePasswordComplete()
    }
  }

  LoginScreen(
    uiState = uiState,
    onMailChange = viewModel::onEmailChange,
    onSendOneTimePasswordClick = viewModel::onSendOneTimePasswordClick,
    onGoogleLoginClick = viewModel::onGoogleLoginClick,
    onSignUpClick = onSignUpClick,
  )
}
