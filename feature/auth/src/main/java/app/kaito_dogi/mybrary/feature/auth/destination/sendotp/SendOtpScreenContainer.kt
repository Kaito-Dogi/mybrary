package app.kaito_dogi.mybrary.feature.auth.destination.sendotp

import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import app.kaito_dogi.mybrary.core.ui.navigation.route.AuthRoute
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@Composable
internal fun SendOtpScreenContainer(
  onSendOtpComplete: (email: String, AuthRoute.VerifyOtp.Page) -> Unit,
  onLoginComplete: () -> Unit,
  onSignUpComplete: () -> Unit,
  viewModel: SendOtpViewModel = hiltViewModel(),
) {
  val compositionScope = rememberCoroutineScope()
  val pagerState = rememberPagerState(
    initialPage = AuthRoute.VerifyOtp.Page.Login.ordinal,
    pageCount = { AuthRoute.VerifyOtp.Page.entries.size },
  )

  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  // FIXME: 適切な実装に変更する
  val hasSession by viewModel.hasSessionFlow.collectAsStateWithLifecycle()
  if (hasSession) {
    LaunchedEffect(Unit) {
      onLoginComplete()
    }
  }
  LaunchedEffect(Unit) {
    viewModel.onInit()
  }

  val lifecycleOwner = LocalLifecycleOwner.current
  LaunchedEffect(viewModel, lifecycleOwner) {
    viewModel.uiEvent
      .flowWithLifecycle(lifecycleOwner.lifecycle)
      .onEach { uiEvent ->
        when (uiEvent) {
          SendOtpUiEvent.IsOtpSent -> AuthRoute.VerifyOtp.Page.entries
            .find { it.ordinal == pagerState.currentPage }?.let { page ->
              onSendOtpComplete(
                uiState.email,
                page,
              )
            }

          SendOtpUiEvent.IsLoggedInWithGoogle -> onLoginComplete()
          SendOtpUiEvent.IsLoggedInAsGuest -> onLoginComplete()
          SendOtpUiEvent.IsSignedUpWithGoogle -> onSignUpComplete()
          SendOtpUiEvent.IsSignedUpAsGuest -> onSignUpComplete()
        }
      }
      .launchIn(scope = this)
  }

  SendOtpScreen(
    uiState = uiState,
    pagerState = pagerState,
    onEmailChange = viewModel::onEmailChange,
    onSendOtpClick = viewModel::onSendOtpClick,
    onGoogleLoginClick = viewModel::onGoogleLoginClick,
    onAnonymousLoginClick = viewModel::onAnonymousLoginClick,
    onSignUpClick = {
      compositionScope.launch {
        pagerState.animateScrollToPage(
          page = AuthRoute.VerifyOtp.Page.SignUp.ordinal,
        )
      }
    },
    onGoogleSignUpClick = viewModel::onGoogleSignUpClick,
    onAnonymousSignUpClick = viewModel::onAnonymousSignUpClick,
    onLoginClick = {
      compositionScope.launch {
        pagerState.animateScrollToPage(
          page = AuthRoute.VerifyOtp.Page.Login.ordinal,
        )
      }
    },
  )
}
