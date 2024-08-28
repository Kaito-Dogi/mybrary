package app.kaito_dogi.mybrary.core.api.rakuten.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemsListItemResponse(
  @SerialName("Item")
  val item: ItemResponse,
)
