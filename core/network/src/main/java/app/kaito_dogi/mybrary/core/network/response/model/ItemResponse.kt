package app.kaito_dogi.mybrary.core.network.response.model

import kotlinx.serialization.Serializable

@Serializable
data class ItemResponse(
  val id: String,
  val volumeInfo: VolumeInfoResponse? = null,
)
