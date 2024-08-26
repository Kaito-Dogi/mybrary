package app.kaito_dogi.mybrary.feature.sendotp.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.TextField
import app.kaito_dogi.mybrary.core.designsystem.component.button.PrimaryButton
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

@Composable
internal fun SendOtpSection(
  email: String,
  isSendingOtp: Boolean,
  onEmailChange: (String) -> Unit,
  onSendOtpClick: () -> Unit,
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
      placeholderResId = R.string.auth_placeholder_enter_your_email_address,
      leadingIconResId = R.drawable.icon_mail,
      leadingIconAltResId = R.string.auth_alt_email_address,
      keyboardType = KeyboardType.Email,
      imeAction = ImeAction.Send,
      onSend = onSendOtpClick,
      singleLine = true,
    )

    PrimaryButton(
      textResId = R.string.auth_text_send_otp,
      onClick = onSendOtpClick,
      modifier = Modifier.fillMaxWidth(),
      iconResId = R.drawable.icon_send,
      altResId = R.string.auth_alt_send_otp,
      isLoading = isSendingOtp,
    )
  }
}

@Preview
@Composable
private fun SendOtpSectionPreview() {
  MybraryTheme {
    SendOtpSection(
      email = "",
      isSendingOtp = false,
      onEmailChange = {},
      onSendOtpClick = {},
    )
  }
}
