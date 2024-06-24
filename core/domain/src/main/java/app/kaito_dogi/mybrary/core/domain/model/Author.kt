package app.kaito_dogi.mybrary.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Author(
  val id: AuthorId,
  val name: String,
)
