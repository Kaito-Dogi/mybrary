package app.kaito_dogi.mybrary.core.api.rakuten.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetBooksBookSearchResponse(
  @SerialName("Items")
  val items: List<ItemResponse>,
  val page: Int,
)
