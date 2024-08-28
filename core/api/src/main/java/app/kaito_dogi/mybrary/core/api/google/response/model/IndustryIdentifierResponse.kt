package app.kaito_dogi.mybrary.core.api.google.response.model

import kotlinx.serialization.Serializable

@Serializable
data class IndustryIdentifierResponse(
  val type: IndustryIdentifierType,
  val identifier: String,
)
