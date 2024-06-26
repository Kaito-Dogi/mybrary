package app.kaito_dogi.mybrary.core.api.response

import app.kaito_dogi.mybrary.core.api.response.model.ItemResponse
import kotlinx.serialization.Serializable

@Serializable
data class GetVolumesResponse(
  val items: List<ItemResponse>,
)
