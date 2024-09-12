package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.PrimaryButton
import app.kaito_dogi.mybrary.core.designsystem.component.TertiaryButton
import app.kaito_dogi.mybrary.core.designsystem.component.TextField
import app.kaito_dogi.mybrary.core.designsystem.component.TopAppBar
import app.kaito_dogi.mybrary.core.designsystem.ext.plus
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R
import app.kaito_dogi.mybrary.core.ui.navigation.MybraryRoute

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
      TopAppBar(
        textResId = R.string.verify_otp_text_verify_otp,
        navigationIconResId = R.drawable.icon_arrow_back,
        navigationIconAltResId = R.string.verify_otp_back,
        onNavigationIconClick = onNavigationIconClick,
      )
    },
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding.plus(horizontal = MybraryTheme.spaces.md)),
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.md),
    ) {
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

      PrimaryButton(
        textResId = when (uiState.page) {
          MybraryRoute.VerifyOtp.Page.Login -> R.string.verify_otp_text_login
          MybraryRoute.VerifyOtp.Page.SignUp -> R.string.verify_otp_text_sign_up
        },
        onClick = onVerifyOtpClick,
        modifier = Modifier.fillMaxWidth(),
        isLoading = uiState.isOtpVerifying,
      )
      Text(text = stringResource(id = R.string.verify_otp_text_it_may_take_a_few_minutes))
      TertiaryButton(
        textResId = R.string.verify_otp_text_resend_otp,
        onClick = onResendOtpClick,
        modifier = Modifier.fillMaxWidth(),
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
        page = MybraryRoute.VerifyOtp.Page.Login,
      ),
      onNavigationIconClick = {},
      onOtpChange = {},
      onVerifyOtpClick = {},
      onResendOtpClick = {},
    )
  }
}
