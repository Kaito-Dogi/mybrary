package app.kaito_dogi.mybrary.feature.auth.destination.verifyotp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Gap
import app.kaito_dogi.mybrary.core.designsystem.component.PrimaryButton
import app.kaito_dogi.mybrary.core.designsystem.component.TertiaryButton
import app.kaito_dogi.mybrary.core.designsystem.component.TextField
import app.kaito_dogi.mybrary.core.designsystem.ext.plus
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R
import app.kaito_dogi.mybrary.core.ui.navigation.route.AuthRoute
import app.kaito_dogi.mybrary.feature.auth.destination.verifyotp.component.VerifyOtpTopAppBar

@Composable
internal fun VerifyOtpScreen(
  uiState: VerifyOtpUiState,
  onNavigationIconClick: () -> Unit,
  onOtpChange: (String) -> Unit,
  onVerifyOtpClick: () -> Unit,
  onResendOtpClick: () -> Unit,
) {
  Scaffold(
    topBar = {
      VerifyOtpTopAppBar(onNavigationIconClick = onNavigationIconClick)
    },
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding.plus(horizontal = MybraryTheme.spaces.md)),
    ) {
      Text(
        text = stringResource(
          id = R.string.verify_otp_text_enter_otp_sent_to,
          uiState.maskedEmail,
        ),
      )

      Gap(height = MybraryTheme.spaces.xl)

      TextField(
        value = uiState.otp,
        onValueChange = onOtpChange,
        placeholderResId = R.string.verify_otp_placeholder_enter_otp,
        modifier = Modifier.fillMaxWidth(),
        leadingIconResId = R.drawable.icon_key,
        leadingIconAltResId = R.string.verify_otp_alt_otp,
        keyboardType = KeyboardType.NumberPassword,
        imeAction = ImeAction.Send,
        onSend = onVerifyOtpClick,
        singleLine = true,
      )

      Gap(height = MybraryTheme.spaces.md)

      PrimaryButton(
        textResId = when (uiState.page) {
          AuthRoute.VerifyOtp.Page.Login -> R.string.verify_otp_text_login
          AuthRoute.VerifyOtp.Page.SignUp -> R.string.verify_otp_text_sign_up
        },
        onClick = onVerifyOtpClick,
        modifier = Modifier
          .fillMaxWidth()
          .imePadding(),
        isLoading = uiState.isOtpVerifying,
      )

      Spacer(modifier = Modifier.weight(1f))

      Text(text = stringResource(id = R.string.verify_otp_text_it_may_take_a_few_minutes))

      Gap(height = MybraryTheme.spaces.xxs)

      TertiaryButton(
        textResId = R.string.verify_otp_text_resend_otp,
        onClick = onResendOtpClick,
        modifier = Modifier
          .fillMaxWidth()
          .padding(bottom = MybraryTheme.spaces.sm),
        isLoading = uiState.isOtpResending,
      )
    }
  }
}

@Preview
@Composable
private fun VerifyOtpScreenPreview() {
  MybraryTheme {
    VerifyOtpScreen(
      uiState = VerifyOtpUiState.createInitialValue(
        page = AuthRoute.VerifyOtp.Page.Login,
        email = "kendobu0405@gmail.com",
      ),
      onNavigationIconClick = {},
      onOtpChange = {},
      onVerifyOtpClick = {},
      onResendOtpClick = {},
    )
  }
}
