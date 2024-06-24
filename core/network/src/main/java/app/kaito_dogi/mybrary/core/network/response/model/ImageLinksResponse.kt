package app.kaito_dogi.mybrary.core.network.response.model

import kotlinx.serialization.Serializable

@Serializable
data class ImageLinksResponse(
  val thumbnail: String? = null,
)
