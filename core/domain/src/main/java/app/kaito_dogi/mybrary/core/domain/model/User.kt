package app.kaito_dogi.mybrary.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
  val id: UserId,
  val name: String,
  val email: String,
)
