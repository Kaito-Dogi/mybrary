package app.kaito_dogi.mybrary.feature.signin

internal sealed interface SignInUiEvent {
  data object OnOtpSend : SignInUiEvent
  data object OnGoogleSignIn : SignInUiEvent
  data object OnAnonymousSignIn : SignInUiEvent
}
