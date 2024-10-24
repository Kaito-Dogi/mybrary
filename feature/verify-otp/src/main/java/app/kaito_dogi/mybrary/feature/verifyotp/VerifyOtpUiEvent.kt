package app.kaito_dogi.mybrary.feature.verifyotp

internal sealed interface VerifyOtpUiEvent {
  data object OnVerifyOtp : VerifyOtpUiEvent
  data object OnResendOtp : VerifyOtpUiEvent
}
