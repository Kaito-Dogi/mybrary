package app.kaito_dogi.mybrary.core.api.mybrary.request

import kotlinx.serialization.Serializable

@Serializable
data class PostVerifyOtpRequest(
  val email: String,
  val otp: String,
)
