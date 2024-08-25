package app.kaito_dogi.mybrary.feature.sendotp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Gap
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.navigation.MybraryRoute
import app.kaito_dogi.mybrary.feature.sendotp.component.DividerSection
import app.kaito_dogi.mybrary.feature.sendotp.component.HorizontalPagerIndicator
import app.kaito_dogi.mybrary.feature.sendotp.component.LogoSection
import app.kaito_dogi.mybrary.feature.sendotp.component.SendOtpSection
import app.kaito_dogi.mybrary.feature.sendotp.page.LoginPage
import app.kaito_dogi.mybrary.feature.sendotp.page.SignUpPage

@Composable
internal fun SendOtpScreen(
  uiState: SendOtpUiState,
  pagerState: PagerState,
  onEmailChange: (String) -> Unit,
  onSendOtpClick: () -> Unit,
  onGoogleLoginClick: () -> Unit,
  onSignUpClick: () -> Unit,
  onGoogleSignUpClick: () -> Unit,
  onLoginClick: () -> Unit,
) {
  Scaffold(
    modifier = Modifier.fillMaxSize(),
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(
          brush = Brush.linearGradient(
            colors = listOf(
              MybraryTheme.colorScheme.background,
              MybraryTheme.colorScheme.secondaryContainer,
              MybraryTheme.colorScheme.errorContainer,
            ),
            start = Offset(0f, 0f),
            end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY),
          ),
        )
        .imePadding(),
    ) {
      LogoSection(
        modifier = Modifier.padding(
          top = innerPadding.calculateTopPadding() + MybraryTheme.space.xxxl,
        ),
      )

      Gap(height = MybraryTheme.space.xxxl)

      SendOtpSection(
        email = uiState.email,
        isSendingOtp = uiState.isOtpSending,
        onEmailChange = onEmailChange,
        onSendOtpClick = onSendOtpClick,
        modifier = Modifier.padding(horizontal = MybraryTheme.space.xl),
      )

      Gap(height = MybraryTheme.space.xl)

      DividerSection(
        modifier = Modifier.padding(horizontal = MybraryTheme.space.xl),
      )

      Gap(height = MybraryTheme.space.xl)

      HorizontalPager(
        modifier = Modifier.weight(1f),
        state = pagerState,
        contentPadding = PaddingValues(horizontal = MybraryTheme.space.xl),
        pageSpacing = MybraryTheme.space.xl,
      ) { page ->
        when (page) {
          MybraryRoute.VerifyOtp.Page.Login.ordinal -> LoginPage(
            isLoggingIn = uiState.isLoggingIn,
            onGoogleLoginClick = onGoogleLoginClick,
            onSignUpClick = onSignUpClick,
          )

          MybraryRoute.VerifyOtp.Page.SignUp.ordinal -> SignUpPage(
            isSigningUp = uiState.isSigningUp,
            onGoogleSignUpClick = onGoogleSignUpClick,
            onLoginClick = onLoginClick,
          )
        }
      }

      Gap(height = MybraryTheme.space.xl)

      HorizontalPagerIndicator(
        currentPage = pagerState.currentPage,
        modifier = Modifier
          .fillMaxWidth()
          .padding(
            bottom = innerPadding.calculateBottomPadding() + MybraryTheme.space.xl,
          ),
      )
    }
  }
}

@Preview
@Composable
private fun SendOtpScreenPreview() {
  MybraryTheme {
    SendOtpScreen(
      uiState = SendOtpUiState.InitialValue,
      pagerState = rememberPagerState(pageCount = { MybraryRoute.VerifyOtp.Page.entries.size }),
      onEmailChange = {},
      onSendOtpClick = {},
      onGoogleLoginClick = {},
      onSignUpClick = {},
      onGoogleSignUpClick = {},
      onLoginClick = {},
    )
  }
}
