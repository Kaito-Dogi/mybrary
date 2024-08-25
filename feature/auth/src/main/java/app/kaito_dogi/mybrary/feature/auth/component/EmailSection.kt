package app.kaito_dogi.mybrary.feature.auth.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Icon
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.component.button.PrimaryButton
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

@Composable
internal fun EmailSection(
  email: String,
  onEmailChange: (String) -> Unit,
  onSendOtpClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.spacedBy(MybraryTheme.space.md),
  ) {
    TextField(
      value = email,
      onValueChange = onEmailChange,
      modifier = Modifier.fillMaxWidth(),
      placeholder = {
        Text(textResId = R.string.auth_placeholder_enter_your_email_address)
      },
      leadingIcon = {
        Icon(
          iconResId = R.drawable.icon_mail,
          altResId = R.string.auth_alt_email_address,
        )
      },
      keyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.Email,
        imeAction = ImeAction.Send,
      ),
      keyboardActions = KeyboardActions(
        onSend = { onSendOtpClick() },
      ),
      singleLine = true,
    )

    PrimaryButton(
      textResId = R.string.auth_text_send_otp,
      onClick = onSendOtpClick,
      modifier = Modifier.fillMaxWidth(),
      iconResId = R.drawable.icon_send,
      altResId = R.string.auth_alt_send_otp,
    )
  }
}

@Preview
@Composable
private fun EmailSectionPreview() {
  MybraryTheme {
    EmailSection(
      email = "",
      onEmailChange = {},
      onSendOtpClick = {},
    )
  }
}
