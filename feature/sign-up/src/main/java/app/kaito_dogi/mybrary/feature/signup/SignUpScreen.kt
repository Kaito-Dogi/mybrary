package app.kaito_dogi.mybrary.feature.signup

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
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.component.PrimaryButton
import app.kaito_dogi.mybrary.core.designsystem.component.SecondaryButton
import app.kaito_dogi.mybrary.core.designsystem.ext.plus
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.component.OrDivider
import app.kaito_dogi.mybrary.core.ui.component.OtpSection
import app.kaito_dogi.mybrary.core.ui.component.TermsOfUsePrivacyPolicyText
import app.kaito_dogi.mybrary.feature.signup.component.NavigateToSignInSection

@Composable
internal fun SignUpScreen(
  uiState: SignUpUiState,
  onEmailChange: (String) -> Unit,
  onSendOtpClick: () -> Unit,
  onGoogleSignUpClick: () -> Unit,
  onAnonymousSignUpClick: () -> Unit,
  onNavigateToSignInClick: () -> Unit,
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
        isLoading = uiState.isOtpSending,
      )

      OrDivider(
        modifier = Modifier.padding(vertical = MybraryTheme.spaces.xl),
      )

      Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.sm),
      ) {
        SecondaryButton(
          textResId = R.string.sign_up_text_sign_up_with_google,
          onClick = onGoogleSignUpClick,
          modifier = Modifier.fillMaxWidth(),
          iconResId = R.drawable.icon_google,
          altResId = R.string.sign_up_alt_sign_up_with_google,
          iconTint = Color.Unspecified,
          isLoading = uiState.isGoogleSigningUp,
        )

        PrimaryButton(
          textResId = R.string.sign_up_text_continue_as_anonymous,
          onClick = onAnonymousSignUpClick,
          modifier = Modifier.fillMaxWidth(),
          iconResId = R.drawable.icon_person,
          altResId = R.string.sign_up_alt_continue_as_anonymous,
          isLoading = uiState.isAnonymousSigningUp,
        )

        NavigateToSignInSection(
          onClick = onNavigateToSignInClick,
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
private fun SignUpScreenPreview() {
  MybraryTheme {
    SignUpScreen(
      uiState = SignUpUiState.InitialValue,
      onEmailChange = {},
      onSendOtpClick = {},
      onGoogleSignUpClick = {},
      onAnonymousSignUpClick = {},
      onNavigateToSignInClick = {},
      onHCaptchaSuccess = {},
      onHCaptchaFailure = {},
    )
  }
}
