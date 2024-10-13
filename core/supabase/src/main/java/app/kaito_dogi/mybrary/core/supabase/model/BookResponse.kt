package app.kaito_dogi.mybrary.core.supabase.model

import app.kaito_dogi.mybrary.core.data.dto.BookDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class BookResponse(
  val bookId: String,
  val title: String,
  @SerialName("image_url")
  val imageUrl: String,
  val authors: String,
  val publisher: String,
  val isbn: String,
  @SerialName("is_archived")
  val genre: Int,
  @SerialName("rakuten_url")
  val rakutenUrl: String,
  @SerialName("amazon_url")
  val amazonUrl: String? = null,
) {
  fun toDto() = BookDto(
    bookId = this.bookId,
    title = this.title,
    imageUrl = this.imageUrl,
    authors = this.authors,
    publisher = this.publisher,
    isbn = this.isbn,
    genre = this.genre,
    rakutenUrl = this.rakutenUrl,
    amazonUrl = this.amazonUrl,
  )
}
