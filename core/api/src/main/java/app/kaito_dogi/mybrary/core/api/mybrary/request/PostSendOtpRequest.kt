package app.kaito_dogi.mybrary.core.api.mybrary.request

import kotlinx.serialization.Serializable

@Serializable
data class PostSendOtpRequest(
  val email: String,
)
