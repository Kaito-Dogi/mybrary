package app.kaito_dogi.mybrary.feature.sendotp

import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import app.kaito_dogi.mybrary.core.navigation.MybraryRoute
import kotlinx.coroutines.launch

@Composable
internal fun SendOtpScreenContainer() {
  val coroutineScope = rememberCoroutineScope()
  val pagerState = rememberPagerState(
    initialPage = MybraryRoute.VerifyOtp.Page.Login.ordinal,
    pageCount = { MybraryRoute.VerifyOtp.Page.entries.size },
  )

  SendOtpScreen(
    uiState = SendOtpUiState.InitialValue,
    pagerState = pagerState,
    onEmailChange = {},
    onSendOtpClick = {},
    onGoogleLoginClick = {},
    onSignUpClick = {
      coroutineScope.launch {
        pagerState.animateScrollToPage(
          page = MybraryRoute.VerifyOtp.Page.SignUp.ordinal,
        )
      }
    },
    onGoogleSignUpClick = {},
    onLoginClick = {
      coroutineScope.launch {
        pagerState.animateScrollToPage(
          page = MybraryRoute.VerifyOtp.Page.Login.ordinal,
        )
      }
    },
  )
}
