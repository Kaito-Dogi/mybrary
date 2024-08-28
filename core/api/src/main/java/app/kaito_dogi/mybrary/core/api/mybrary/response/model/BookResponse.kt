package app.kaito_dogi.mybrary.core.api.mybrary.response.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
  val id: Long,
  val title: String,
  @SerialName("image_url")
  val imageUrl: String,
  val isbn: String,
  val publisher: String,
  @SerialName("author")
  val authors: List<AuthorResponse>,
)
