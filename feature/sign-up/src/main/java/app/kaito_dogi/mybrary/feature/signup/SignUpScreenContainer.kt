package app.kaito_dogi.mybrary.feature.signup

import androidx.compose.runtime.Composable

@Composable
internal fun SignUpScreenContainer() {
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
