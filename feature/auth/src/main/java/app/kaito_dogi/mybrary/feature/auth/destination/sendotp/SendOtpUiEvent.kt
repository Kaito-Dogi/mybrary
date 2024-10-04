package app.kaito_dogi.mybrary.feature.auth.destination.sendotp

sealed interface SendOtpUiEvent {
  data object IsOtpSent : SendOtpUiEvent
  data object IsLoggedInWithGoogle : SendOtpUiEvent
  data object IsLoggedInAsGuest : SendOtpUiEvent
  data object IsSignedUpWithGoogle : SendOtpUiEvent
  data object IsSignedUpAsGuest : SendOtpUiEvent
}
