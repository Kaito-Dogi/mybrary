package app.kaito_dogi.mybrary.feature.signup

internal sealed interface SignUpUiEvent {
  data object OnSendOtp : SignUpUiEvent
  data object OnGoogleSignUp : SignUpUiEvent
  data object OnAnonymousSignUp : SignUpUiEvent
}
