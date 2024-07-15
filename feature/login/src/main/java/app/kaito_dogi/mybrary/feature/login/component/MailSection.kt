package app.kaito_dogi.mybrary.feature.login.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
  password: String,
  onPasswordChange: (String) -> Unit,
  isPasswordVisible: Boolean,
  onVisibilityClick: () -> Unit,
  onMailLoginClick: () -> Unit,
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
        imeAction = ImeAction.Next,
      ),
      singleLine = true,
    )

    TextField(
      value = password,
      onValueChange = onPasswordChange,
      modifier = Modifier.fillMaxWidth(),
      placeholder = {
        Text(textResId = R.string.login_placeholder_enter_your_password)
      },
      leadingIcon = {
        Icon(
          iconResId = R.drawable.icon_key,
          descResId = R.string.login_desc_password,
        )
      },
      trailingIcon = {
        IconButton(onClick = onVisibilityClick) {
          Icon(
            iconResId = if (isPasswordVisible) R.drawable.icon_visibility else R.drawable.icon_visibility_off,
            descResId = if (isPasswordVisible) R.string.login_desc_hide_password else R.string.login_desc_show_password,
          )
        }
      },
      visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
      keyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.Password,
        imeAction = ImeAction.Send,
      ),
      keyboardActions = KeyboardActions(
        onSend = { onMailLoginClick() },
      ),
      singleLine = true,
    )

    Button(
      onClick = onMailLoginClick,
      modifier = Modifier.fillMaxWidth(),
    ) {
      Icon(
        iconResId = R.drawable.icon_mail,
        descResId = R.string.login_desc_login_with_your_email_address,
      )

      Gap(width = MybraryTheme.space.xs)

      Text(textResId = R.string.login_text_login_with_your_email_address)
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
      password = "",
      onPasswordChange = {},
      isPasswordVisible = false,
      onVisibilityClick = {},
      onMailLoginClick = {},
    )
  }
}
