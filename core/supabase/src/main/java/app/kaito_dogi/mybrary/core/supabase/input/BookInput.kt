package app.kaito_dogi.mybrary.core.supabase.input

import app.kaito_dogi.mybrary.core.data.command.PostBookCommand
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

internal fun PostBookCommand.toBookInput() = BookInput(
  title = this.title,
  imageUrl = this.imageUrl,
  authors = this.authors,
  publisher = this.publisher,
  isbn = this.isbn,
  genre = this.genre,
  rakutenUrl = this.rakutenUrl,
)
