package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.PrimaryButton
import app.kaito_dogi.mybrary.core.designsystem.component.TextField
import app.kaito_dogi.mybrary.core.designsystem.component.TopAppBar
import app.kaito_dogi.mybrary.core.designsystem.ext.plus
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.navigation.MybraryRoute
import app.kaito_dogi.mybrary.core.ui.R

@Composable
internal fun VerifyOtpScreen(
  uiState: VerifyOtpUiState,
  onOtpChange: (String) -> Unit,
  onVerifyOtpClick: () -> Unit,
) {
  Scaffold(
    topBar = { TopAppBar(textResId = R.string.auth_text_enter_otp) },
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
        placeholderResId = R.string.auth_placeholder_enter_otp,
        modifier = Modifier.fillMaxWidth(),
        leadingIconResId = R.drawable.icon_key,
        leadingIconAltResId = R.string.auth_alt_otp,
        keyboardType = KeyboardType.NumberPassword,
        imeAction = ImeAction.Send,
        onSend = onVerifyOtpClick,
        singleLine = true,
      )

      PrimaryButton(
        textResId = when (uiState.page) {
          MybraryRoute.VerifyOtp.Page.Login -> R.string.auth_text_login
          MybraryRoute.VerifyOtp.Page.SignUp -> R.string.auth_text_sign_up
        },
        onClick = onVerifyOtpClick,
        modifier = Modifier.fillMaxWidth(),
        isLoading = uiState.isOtpVerifying,
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
      onOtpChange = {},
      onVerifyOtpClick = {},
    )
  }
}
