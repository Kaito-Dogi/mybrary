package app.kaito_dogi.mybrary.feature.verifyotp

internal sealed interface VerifyOtpUiEvent {
  data object OnOtpVerify : VerifyOtpUiEvent
  data object OnOtpResend : VerifyOtpUiEvent
}
