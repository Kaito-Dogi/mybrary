package app.kaito_dogi.mybrary.core.api.mybrary.response.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
  val id: Long,
  @SerialName("external_id")
  val externalId: String,
  val title: String,
  @SerialName("image_url")
  val imageUrl: String? = null,
  val isbn10: String? = null,
  val isbn13: String? = null,
  @SerialName("page_count")
  val pageCount: Int? = null,
  val publisher: String? = null,
  @SerialName("author")
  val authors: List<AuthorResponse>,
)
