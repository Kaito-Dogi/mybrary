package app.kaito_dogi.mybrary.core.api.googlebooks.response

import app.kaito_dogi.mybrary.core.api.googlebooks.response.model.ItemResponse
import kotlinx.serialization.Serializable

@Serializable
data class GetVolumesResponse(
  val items: List<ItemResponse>,
)
