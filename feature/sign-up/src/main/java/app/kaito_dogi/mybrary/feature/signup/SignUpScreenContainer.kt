package app.kaito_dogi.mybrary.feature.signup

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
internal fun SignUpScreenContainer(
  viewModel: SignUpViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  val lifecycleOwner = LocalLifecycleOwner.current
  LaunchedEffect(viewModel, lifecycleOwner) {
    viewModel.uiEvent
      .flowWithLifecycle(lifecycleOwner.lifecycle)
      .onEach { uiEvent ->
        when (uiEvent) {
          SignUpUiEvent.OnAnonymousSignUp -> TODO()
          SignUpUiEvent.OnGoogleSignUp -> TODO()
          SignUpUiEvent.OnSendOtp -> TODO()
        }
      }
      .launchIn(scope = this)
  }

  SignUpScreen(
    uiState = uiState,
    onEmailChange = viewModel::onEmailChange,
    onSendOtpClick = viewModel::onSendOtpClick,
    onGoogleSignUpClick = viewModel::onGoogleSignUpClick,
    onAnonymousSignUpClick = viewModel::onAnonymousSignUpClick,
    onNavigateToSignInClick = {},
    onHCaptchaSuccess = viewModel::onHCaptchaSuccess,
    onHCaptchaFailure = viewModel::onHCaptchaFailure,
  )
}
