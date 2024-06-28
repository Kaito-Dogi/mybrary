package app.kaito_dogi.mybrary.core.api.googlebooks.response.model

import kotlinx.serialization.Serializable

@Serializable
data class IndustryIdentifierResponse(
  val type: IndustryIdentifierType? = null,
  val identifier: String? = null,
)
