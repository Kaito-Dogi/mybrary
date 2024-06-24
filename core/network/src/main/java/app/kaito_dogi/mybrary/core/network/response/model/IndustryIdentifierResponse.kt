package app.kaito_dogi.mybrary.core.network.response.model

import kotlinx.serialization.Serializable

@Serializable
data class IndustryIdentifierResponse(
  val type: IndustryIdentifierType? = null,
  val identifier: String? = null,
)
