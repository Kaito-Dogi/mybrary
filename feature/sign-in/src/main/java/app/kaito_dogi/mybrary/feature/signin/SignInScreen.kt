package app.kaito_dogi.mybrary.feature.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.core.hcaptcha.HCaptchaDialog
import app.kaito_dogi.mybrary.core.common.model.CaptchaToken
import app.kaito_dogi.mybrary.core.designsystem.component.SecondaryButton
import app.kaito_dogi.mybrary.core.designsystem.ext.plus
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R
import app.kaito_dogi.mybrary.core.ui.component.OrDivider
import app.kaito_dogi.mybrary.core.ui.component.OtpSection
import app.kaito_dogi.mybrary.core.ui.component.TermsOfUsePrivacyPolicyText
import app.kaito_dogi.mybrary.feature.signin.component.NavigateToSignUpSection

@Composable
internal fun SignInScreen(
  uiState: SignInUiState,
  onEmailChange: (String) -> Unit,
  onSendOtpClick: () -> Unit,
  onGoogleSignInClick: () -> Unit,
  onNavigateToSignUpClick: () -> Unit,
  onHCaptchaSuccess: (CaptchaToken) -> Unit,
  onHCaptchaFailure: () -> Unit,
) {
  Scaffold(
    modifier = Modifier.fillMaxSize(),
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(MybraryTheme.backgroundBrush)
        .padding(
          innerPadding.plus(
            start = MybraryTheme.spaces.md,
            end = MybraryTheme.spaces.md,
            bottom = MybraryTheme.spaces.xl,
          ),
        ),
    ) {
      Text(
        text = "Mybrary",
        modifier = Modifier
          .padding(vertical = MybraryTheme.spaces.xxxl)
          .fillMaxWidth(),
        textAlign = TextAlign.Center,
        style = MybraryTheme.typography.displayMedium,
      )

      OtpSection(
        email = uiState.email,
        onEmailChange = onEmailChange,
        onSendOtpClick = onSendOtpClick,
        isLoading = false,
      )

      OrDivider(
        modifier = Modifier.padding(vertical = MybraryTheme.spaces.xl),
      )

      Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.xs),
      ) {
        SecondaryButton(
          textResId = R.string.sign_in_text_sign_in_with_google,
          onClick = onGoogleSignInClick,
          modifier = Modifier.fillMaxWidth(),
          iconResId = R.drawable.icon_google,
          altResId = R.string.sign_in_alt_sign_in_with_google,
          iconTint = Color.Unspecified,
          isLoading = uiState.isGoogleSigningIn,
        )

        NavigateToSignUpSection(
          onClick = onNavigateToSignUpClick,
          modifier = Modifier
            .padding(vertical = MybraryTheme.spaces.xxs)
            .fillMaxWidth(),
        )
      }

      Spacer(modifier = Modifier.weight(1f))

      TermsOfUsePrivacyPolicyText(
        modifier = Modifier.fillMaxWidth(),
      )
    }

    if (uiState.isHCaptchaVisible) {
      HCaptchaDialog(
        onSuccess = onHCaptchaSuccess,
        onFailure = onHCaptchaFailure,
      )
    }
  }
}

@Preview
@Composable
private fun SignInScreenPreview() {
  MybraryTheme {
    SignInScreen(
      uiState = SignInUiState.InitialValue,
      onEmailChange = {},
      onSendOtpClick = {},
      onGoogleSignInClick = {},
      onNavigateToSignUpClick = {},
      onHCaptchaSuccess = {},
      onHCaptchaFailure = {},
    )
  }
}
