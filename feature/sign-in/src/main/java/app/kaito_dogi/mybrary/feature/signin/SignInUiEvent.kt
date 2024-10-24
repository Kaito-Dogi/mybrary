package app.kaito_dogi.mybrary.feature.signin

internal sealed interface SignInUiEvent {
  data object OnSendOtp : SignInUiEvent
  data object OnGoogleSignIn : SignInUiEvent
  data object OnAnonymousSignIn : SignInUiEvent
}
