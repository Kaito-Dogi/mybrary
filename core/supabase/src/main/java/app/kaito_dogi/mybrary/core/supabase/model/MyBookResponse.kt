package app.kaito_dogi.mybrary.core.supabase.model

import app.kaito_dogi.mybrary.core.data.dto.MyBookDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MyBookResponse(
  @SerialName("my_book_id")
  val myBookId: String,
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
  val book: Book,
) {
  fun toDto() = MyBookDto(
    myBookId = this.myBookId,
    title = this.book.title,
    imageUrl = this.book.imageUrl,
    isbn = this.book.isbn,
    publisher = this.book.publisher,
    authors = this.book.authors,
    genre = this.book.genre,
    isPinned = isPinned,
    isFavorite = isFavorite,
    isPublic = isPublic,
    isArchived = isArchived,
  )
}
