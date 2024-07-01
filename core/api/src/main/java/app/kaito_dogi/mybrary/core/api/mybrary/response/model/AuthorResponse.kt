package app.kaito_dogi.mybrary.core.api.mybrary.response.model

import kotlinx.serialization.Serializable

@Serializable
data class AuthorResponse(
  val id: Long,
  val name: String,
)
