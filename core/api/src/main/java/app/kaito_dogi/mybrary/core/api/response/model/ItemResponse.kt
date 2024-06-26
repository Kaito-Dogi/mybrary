package app.kaito_dogi.mybrary.core.api.response.model

import kotlinx.serialization.Serializable

@Serializable
data class ItemResponse(
  val id: String,
  val volumeInfo: VolumeInfoResponse? = null,
)
