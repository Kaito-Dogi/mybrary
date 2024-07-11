package app.kaito_dogi.mybrary.feature.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.snapshotFlow
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle

@Composable
internal fun LoginScreenContainer(
  onLoginComplete: () -> Unit,
  onSignUpClick: () -> Unit,
  viewModel: LoginViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  val lifecycle = LocalLifecycleOwner.current.lifecycle
  val currentOnLoginComplete by rememberUpdatedState(onLoginComplete)
  LaunchedEffect(uiState.isLoggedIn, lifecycle) {
    snapshotFlow { uiState.isLoggedIn }
      .flowWithLifecycle(lifecycle)
      .collect { isLoggedIn ->
        if (isLoggedIn) {
          currentOnLoginComplete()
        }
      }
  }

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
