package app.kaito_dogi.mybrary.core.api.googlebooks.response.model

import kotlinx.serialization.Serializable

@Serializable
data class ItemResponse(
  val id: String,
  val volumeInfo: VolumeInfoResponse? = null,
)
