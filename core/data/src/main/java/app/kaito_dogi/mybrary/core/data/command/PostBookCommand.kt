package app.kaito_dogi.mybrary.core.data.command

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostBookCommand(
  val title: String,
  @SerialName("image_url")
  val imageUrl: String,
  val authors: String,
  val publisher: String,
  val isbn: String,
  val genre: Int,
  @SerialName("rakuten_url")
  val rakutenUrl: String,
)
