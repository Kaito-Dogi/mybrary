package app.kaito_dogi.mybrary.core.api.mybrary.response.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MyBookResponse(
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
  @SerialName("profile")
  val user: UserResponse,
  @SerialName("book")
  val book: BookResponse,
)
