package app.kaito_dogi.mybrary.core.api.mybrary.request

import kotlinx.serialization.Serializable

@Serializable
data class PostEmailLoginRequest(
  val email: String,
  val password: String,
)
