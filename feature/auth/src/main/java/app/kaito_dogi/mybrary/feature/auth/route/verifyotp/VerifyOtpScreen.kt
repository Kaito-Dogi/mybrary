package app.kaito_dogi.mybrary.feature.auth.route.verifyotp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Icon
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.extension.plus
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun VerifyOtpScreen(
  uiState: VerifyOtpUiState,
  onOtpChange: (String) -> Unit,
  onVerifyOtpClick: () -> Unit,
) {
  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Text(textResId = R.string.auth_text_enter_otp)
        },
      )
    },
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding.plus(horizontal = MybraryTheme.space.md)),
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.space.md),
    ) {
      TextField(
        value = uiState.otp,
        onValueChange = onOtpChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
          Text(textResId = R.string.auth_placeholder_enter_otp)
        },
        leadingIcon = {
          Icon(
            iconResId = R.drawable.icon_key,
            descResId = R.string.auth_alt_otp,
          )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
          keyboardType = KeyboardType.NumberPassword,
          imeAction = ImeAction.Send,
        ),
        keyboardActions = KeyboardActions(
          onSend = { onVerifyOtpClick() },
        ),
        singleLine = true,
      )

      Button(
        onClick = onVerifyOtpClick,
        modifier = Modifier.fillMaxWidth(),
      ) {
        when (uiState.page) {
          VerifyOtpUiState.Page.Login -> Text(textResId = R.string.auth_text_login)
          VerifyOtpUiState.Page.SignUp -> Text(textResId = R.string.auth_text_sign_up)
        }
      }
    }
  }
}

@Preview
@Composable
private fun VerifyOtpScreenPreview() {
  MybraryTheme {
    VerifyOtpScreen(
      uiState = VerifyOtpUiState.createInitialValue(
        page = VerifyOtpUiState.Page.Login,
      ),
      onOtpChange = {},
      onVerifyOtpClick = {},
    )
  }
}
