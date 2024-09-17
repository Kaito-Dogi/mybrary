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
import app.kaito_dogi.mybrary.feature.auth.destination.sendotp.component.LoginSection

@Composable
internal fun SignUpPage(
  isSigningUp: Boolean,
  onGoogleSignUpClick: () -> Unit,
  onLoginClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    SecondaryButton(
      textResId = R.string.send_otp_text_sign_up_with_google,
      onClick = onGoogleSignUpClick,
      modifier = Modifier.fillMaxWidth(),
      iconResId = R.drawable.icon_google,
      altResId = R.string.send_otp_alt_sign_up_google,
      iconTint = Color.Unspecified,
      isLoading = isSigningUp,
    )

    Spacer(modifier = Modifier.weight(1f))

    LoginSection(
      onClick = onLoginClick,
      modifier = Modifier.fillMaxWidth(),
    )
  }
}

@Preview
@Composable
private fun SignUpPagePreview() {
  MybraryTheme {
    SignUpPage(
      isSigningUp = false,
      onGoogleSignUpClick = {},
      onLoginClick = {},
    )
  }
}
