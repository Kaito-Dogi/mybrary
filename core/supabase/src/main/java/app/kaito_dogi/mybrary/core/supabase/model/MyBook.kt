package app.kaito_dogi.mybrary.core.supabase.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MyBook(
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
)
