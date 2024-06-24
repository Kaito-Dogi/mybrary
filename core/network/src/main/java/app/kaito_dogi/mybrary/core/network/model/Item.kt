package app.kaito_dogi.mybrary.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Item(
  val id: String,
  val volumeInfo: VolumeInfo,
)
