package app.kaito_dogi.mybrary.core.api.mybrary.response.model

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
  val id: String,
  val name: String,
)
