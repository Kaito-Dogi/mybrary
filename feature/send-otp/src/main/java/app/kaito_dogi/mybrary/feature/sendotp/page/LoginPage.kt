package app.kaito_dogi.mybrary.feature.sendotp.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.SecondaryButton
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R
import app.kaito_dogi.mybrary.feature.sendotp.component.SignUpSection

@Composable
internal fun LoginPage(
  isLoggingIn: Boolean,
  onGoogleLoginClick: () -> Unit,
  onSignUpClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    SecondaryButton(
      textResId = R.string.auth_text_login_with_google,
      onClick = onGoogleLoginClick,
      modifier = Modifier.fillMaxWidth(),
      iconResId = R.drawable.icon_google,
      altResId = R.string.auth_alt_login_with_google,
      iconTint = Color.Unspecified,
      isLoading = isLoggingIn,
    )

    Spacer(modifier = Modifier.weight(1f))

    SignUpSection(onClick = onSignUpClick)
  }
}

@Preview(showBackground = true)
@Composable
private fun LoginPagePreview() {
  MybraryTheme {
    LoginPage(
      isLoggingIn = false,
      onGoogleLoginClick = {},
      onSignUpClick = {},
    )
  }
}
