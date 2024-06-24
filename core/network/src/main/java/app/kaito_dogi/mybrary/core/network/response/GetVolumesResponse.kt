package app.kaito_dogi.mybrary.core.network.response

import app.kaito_dogi.mybrary.core.network.response.model.ItemResponse
import kotlinx.serialization.Serializable

@Serializable
data class GetVolumesResponse(
  val items: List<ItemResponse>,
)
