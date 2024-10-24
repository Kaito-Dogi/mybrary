package app.kaito_dogi.mybrary.core.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.component.PrimaryButton
import app.kaito_dogi.mybrary.core.designsystem.component.TextField
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
fun OtpSection(
  email: String,
  onEmailChange: (String) -> Unit,
  onSendOtpClick: () -> Unit,
  isLoading: Boolean,
  modifier: Modifier = Modifier,
) {
  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.md),
  ) {
    TextField(
      value = email,
      onValueChange = onEmailChange,
      modifier = Modifier.fillMaxWidth(),
      placeholderResId = R.string.sign_up_placeholder_enter_your_email,
      leadingIconResId = R.drawable.icon_mail,
      leadingIconAltResId = R.string.sign_up_alt_your_email,
      keyboardType = KeyboardType.Email,
      imeAction = ImeAction.Send,
      onSend = onSendOtpClick,
      singleLine = true,
    )

    PrimaryButton(
      textResId = R.string.sign_up_text_send_otp,
      onClick = onSendOtpClick,
      modifier = Modifier.fillMaxWidth(),
      iconResId = R.drawable.icon_send,
      altResId = R.string.sign_up_alt_send_otp,
      isLoading = isLoading,
    )
  }
}

@Preview
@Composable
private fun OtpSectionPreview() {
  MybraryTheme {
    OtpSection(
      email = "",
      onEmailChange = {},
      onSendOtpClick = {},
      isLoading = false,
    )
  }
}
