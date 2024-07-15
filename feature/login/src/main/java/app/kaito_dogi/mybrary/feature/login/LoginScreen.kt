package app.kaito_dogi.mybrary.feature.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Gap
import app.kaito_dogi.mybrary.core.designsystem.component.Icon
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.extension.plus
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R
import app.kaito_dogi.mybrary.feature.login.component.DividerSection
import app.kaito_dogi.mybrary.feature.login.component.LogoSection
import app.kaito_dogi.mybrary.feature.login.component.MailSection
import app.kaito_dogi.mybrary.feature.login.component.SignUpSection

@Composable
internal fun LoginScreen(
  uiState: LoginUiState,
  onMailChange: (String) -> Unit,
  onPasswordChange: (String) -> Unit,
  onVisibilityClick: () -> Unit,
  onMailLoginClick: () -> Unit,
  onGoogleLoginClick: () -> Unit,
  onSignUpClick: () -> Unit,
) {
  Scaffold(
    modifier = Modifier.imePadding(),
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(
          innerPadding.plus(
            horizontal = MybraryTheme.space.xl,
            vertical = MybraryTheme.space.xxxl,
          ),
        ),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      LogoSection(
        modifier = Modifier.weight(1f),
      )

      Gap(height = MybraryTheme.space.xl)

      MailSection(
        email = uiState.email,
        onEmailChange = onMailChange,
        password = uiState.password,
        onPasswordChange = onPasswordChange,
        isPasswordVisible = uiState.isPasswordVisible,
        onVisibilityClick = onVisibilityClick,
        onMailLoginClick = onMailLoginClick,
      )

      Gap(height = MybraryTheme.space.xl)

      DividerSection()

      Gap(height = MybraryTheme.space.xl)

      OutlinedButton(
        onClick = onGoogleLoginClick,
        modifier = Modifier.fillMaxWidth(),
      ) {
        Icon(
          iconResId = R.drawable.icon_google,
          contentDescriptionResId = R.string.login_content_description_login_with_google,
          tint = Color.Unspecified,
        )

        Gap(width = MybraryTheme.space.xs)

        Text(textResId = R.string.login_text_login_with_google)
      }

      Gap(height = MybraryTheme.space.sm)

      SignUpSection(onClick = onSignUpClick)
    }
  }
}

@Preview
@Composable
private fun LoginScreenPreview() {
  MybraryTheme {
    LoginScreen(
      uiState = LoginUiState.InitialValue,
      onMailChange = {},
      onPasswordChange = {},
      onVisibilityClick = {},
      onMailLoginClick = {},
      onGoogleLoginClick = {},
      onSignUpClick = {},
    )
  }
}
