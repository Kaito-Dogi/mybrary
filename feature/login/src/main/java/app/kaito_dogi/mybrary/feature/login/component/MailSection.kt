package app.kaito_dogi.mybrary.feature.login.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Gap
import app.kaito_dogi.mybrary.core.designsystem.component.Icon
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

@Composable
internal fun MailSection(
  email: String,
  onEmailChange: (String) -> Unit,
  onSendOneTimePasswordClick: () -> Unit,
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
        Text(textResId = R.string.login_placeholder_enter_your_email_address)
      },
      leadingIcon = {
        Icon(
          iconResId = R.drawable.icon_mail,
          descResId = R.string.login_desc_email_address,
        )
      },
      keyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.Email,
        imeAction = ImeAction.Send,
      ),
      keyboardActions = KeyboardActions(
        onSend = { onSendOneTimePasswordClick() },
      ),
      singleLine = true,
    )

    Button(
      onClick = onSendOneTimePasswordClick,
      modifier = Modifier.fillMaxWidth(),
    ) {
      Icon(
        iconResId = R.drawable.icon_send,
        descResId = R.string.login_desc_send_one_time_password,
      )

      Gap(width = MybraryTheme.space.xs)

      Text(textResId = R.string.login_text_send_one_time_password)
    }
  }
}

@Preview
@Composable
private fun MailSectionPreview() {
  MybraryTheme {
    MailSection(
      email = "",
      onEmailChange = {},
      onSendOneTimePasswordClick = {},
    )
  }
}
