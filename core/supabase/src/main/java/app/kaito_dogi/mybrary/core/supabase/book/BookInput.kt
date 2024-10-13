package app.kaito_dogi.mybrary.core.supabase.book

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class BookInput(
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
