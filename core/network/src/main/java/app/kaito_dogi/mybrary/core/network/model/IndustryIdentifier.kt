package app.kaito_dogi.mybrary.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class IndustryIdentifier(
  val type: String,
  val identifier: String,
)
