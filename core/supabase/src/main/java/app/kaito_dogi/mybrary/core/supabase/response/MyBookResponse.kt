package app.kaito_dogi.mybrary.core.supabase.response

import app.kaito_dogi.mybrary.core.data.dto.MyBookDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MyBookResponse(
  val id: String,
  @SerialName("user_id")
  val userId: String,
  @SerialName("book_id")
  val bookId: String,
  @SerialName("is_pinned")
  val isPinned: Boolean,
  @SerialName("is_favorite")
  val isFavorite: Boolean,
  @SerialName("is_public")
  val isPublic: Boolean,
  @SerialName("is_archived")
  val isArchived: Boolean,
  val book: BookResponse,
) {
  fun toMyBookDto() = MyBookDto(
    id = this.id,
    title = this.book.title,
    imageUrl = this.book.imageUrl,
    isbn = this.book.isbn,
    publisher = this.book.publisher,
    authors = this.book.authors.toAuthorsDto(),
    genre = this.book.genre.toGenreDto(),
    isPinned = this.isPinned,
    isFavorite = this.isFavorite,
    isPublic = this.isPublic,
    isArchived = this.isArchived,
  )
}
