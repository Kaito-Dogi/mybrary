package app.kaito_dogi.mybrary.core.supabase.mybook

import app.kaito_dogi.mybrary.core.data.dto.MyBookDto
import app.kaito_dogi.mybrary.core.supabase.model.BookResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MyBookResponse(
  @SerialName("id")
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
  @SerialName("book")
  val bookResponse: BookResponse,
) {
  fun toDto() = MyBookDto(
    myBookId = this.myBookId,
    title = this.bookResponse.title,
    imageUrl = this.bookResponse.imageUrl,
    isbn = this.bookResponse.isbn,
    publisher = this.bookResponse.publisher,
    authors = this.bookResponse.authors,
    genre = this.bookResponse.genre,
    isPinned = isPinned,
    isFavorite = isFavorite,
    isPublic = isPublic,
    isArchived = isArchived,
  )
}
