package app.kaito_dogi.mybrary.feature.auth.destination.sendotp.page

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
import app.kaito_dogi.mybrary.feature.auth.destination.sendotp.component.SignUpSection

@Composable
internal fun LoginPage(
  isLoggingInWithGoogle: Boolean,
  isLoggingInAsGuest: Boolean,
  onGoogleLoginClick: () -> Unit,
  onAnonymousLoginClick: () -> Unit,
  onSignUpClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    SecondaryButton(
      textResId = R.string.send_otp_text_login_with_google,
      onClick = onGoogleLoginClick,
      modifier = Modifier.fillMaxWidth(),
      iconResId = R.drawable.icon_google,
      altResId = R.string.send_otp_alt_login_with_google,
      iconTint = Color.Unspecified,
      isLoading = isLoggingInWithGoogle,
    )

    SecondaryButton(
      textResId = R.string.send_otp_text_login_as_a_guest,
      onClick = onAnonymousLoginClick,
      modifier = Modifier.fillMaxWidth(),
      iconResId = R.drawable.icon_person,
      altResId = R.string.send_otp_alt_login_with_google,
      isLoading = isLoggingInAsGuest,
    )

    Spacer(modifier = Modifier.weight(1f))

    SignUpSection(
      onClick = onSignUpClick,
      modifier = Modifier.fillMaxWidth(),
    )
  }
}

@Preview(showBackground = true)
@Composable
private fun LoginPagePreview() {
  MybraryTheme {
    LoginPage(
      isLoggingInWithGoogle = false,
      isLoggingInAsGuest = false,
      onGoogleLoginClick = {},
      onAnonymousLoginClick = {},
      onSignUpClick = {},
    )
  }
}
