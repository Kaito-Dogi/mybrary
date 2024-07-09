package app.kaito_dogi.mybrary.feature.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun LoginContainer(
  onSignUpClick: () -> Unit,
  viewModel: LoginViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  LoginScreen(
    uiState = uiState,
    onMailChange = viewModel::onEmailChange,
    onPasswordChange = viewModel::onPasswordChange,
    onVisibilityClick = viewModel::onVisibilityChange,
    onMailLoginClick = viewModel::onMailLoginClick,
    onGoogleLoginClick = viewModel::onGoogleLoginClick,
    onSignUpClick = onSignUpClick,
  )
}
