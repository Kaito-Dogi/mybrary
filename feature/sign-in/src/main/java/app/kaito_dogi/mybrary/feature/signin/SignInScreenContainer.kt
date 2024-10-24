package app.kaito_dogi.mybrary.feature.signin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import app.kaito_dogi.mybrary.core.common.model.CaptchaToken
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
internal fun SignInScreenContainer(
  onSendOtp: (email: String, CaptchaToken) -> Unit,
  onSignIn: () -> Unit,
  onNavigateToSignUpClick: () -> Unit,
  viewModel: SignInViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  val lifecycleOwner = LocalLifecycleOwner.current
  LaunchedEffect(viewModel, lifecycleOwner) {
    viewModel.uiEvent.flowWithLifecycle(lifecycleOwner.lifecycle).onEach { uiEvent ->
      when (uiEvent) {
        SignInUiEvent.OnSendOtp -> uiState.captchaToken?.let { captchaToken ->
          onSendOtp(uiState.email, captchaToken)
        }

        SignInUiEvent.OnGoogleSignIn -> onSignIn()
        SignInUiEvent.OnAnonymousSignIn -> onSignIn()
      }
    }.launchIn(scope = this)
  }

  SignInScreen(
    uiState = uiState,
    onEmailChange = viewModel::onEmailChange,
    onSendOtpClick = viewModel::onSendOtpClick,
    onGoogleSignInClick = viewModel::onGoogleSignInClick,
    onNavigateToSignUpClick = onNavigateToSignUpClick,
    onHCaptchaSuccess = viewModel::onHCaptchaSuccess,
    onHCaptchaFailure = viewModel::onHCaptchaFailure,
  )
}
