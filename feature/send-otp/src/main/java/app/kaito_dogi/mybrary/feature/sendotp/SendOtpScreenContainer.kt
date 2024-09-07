package app.kaito_dogi.mybrary.feature.sendotp

import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.kaito_dogi.mybrary.core.ui.navigation.MybraryRoute
import kotlinx.coroutines.launch

@Composable
internal fun SendOtpScreenContainer(
  onSendOtpComplete: (email: String, MybraryRoute.VerifyOtp.Page) -> Unit,
  onLoginComplete: () -> Unit,
  onSignUpComplete: () -> Unit,
  viewModel: SendOtpViewModel = hiltViewModel(),
) {
  val compositionScope = rememberCoroutineScope()
  val pagerState = rememberPagerState(
    initialPage = MybraryRoute.VerifyOtp.Page.Login.ordinal,
    pageCount = { MybraryRoute.VerifyOtp.Page.entries.size },
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

  // FIXME: PageState の保持方法を考える
  if (uiState.isOtpSent) {
    LaunchedEffect(Unit) {
      MybraryRoute.VerifyOtp.Page.entries.find { it.ordinal == pagerState.currentPage }
        ?.let { page ->
          onSendOtpComplete(
            uiState.email,
            page,
          )
        }
      viewModel.onUiEventConsume()
    }
  }

  if (uiState.isLoggedIn) {
    LaunchedEffect(Unit) {
      onLoginComplete()
      viewModel.onUiEventConsume()
    }
  }

  if (uiState.isSignedUp) {
    LaunchedEffect(Unit) {
      onSignUpComplete()
      viewModel.onUiEventConsume()
    }
  }

  SendOtpScreen(
    uiState = uiState,
    pagerState = pagerState,
    onEmailChange = viewModel::onEmailChange,
    onSendOtpClick = viewModel::onSendOtpClick,
    onGoogleLoginClick = viewModel::onGoogleLoginClick,
    onSignUpClick = {
      compositionScope.launch {
        pagerState.animateScrollToPage(
          page = MybraryRoute.VerifyOtp.Page.SignUp.ordinal,
        )
      }
    },
    onGoogleSignUpClick = viewModel::onGoogleSignUpClick,
    onLoginClick = {
      compositionScope.launch {
        pagerState.animateScrollToPage(
          page = MybraryRoute.VerifyOtp.Page.Login.ordinal,
        )
      }
    },
  )
}
