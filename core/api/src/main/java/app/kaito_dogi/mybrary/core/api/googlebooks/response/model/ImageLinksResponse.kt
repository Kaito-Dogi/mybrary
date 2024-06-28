package app.kaito_dogi.mybrary.core.api.googlebooks.response.model

import kotlinx.serialization.Serializable

@Serializable
data class ImageLinksResponse(
  val thumbnail: String? = null,
)
