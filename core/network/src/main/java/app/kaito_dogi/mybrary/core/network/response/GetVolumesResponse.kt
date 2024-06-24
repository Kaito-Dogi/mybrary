package app.kaito_dogi.mybrary.core.network.response

import app.kaito_dogi.mybrary.core.network.model.Item
import kotlinx.serialization.Serializable

@Serializable
data class GetVolumesResponse(
  val items: List<Item>,
)
