package app.kaito_dogi.mybrary.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class MyBook(
  val id: MyBookId,
  val user: User,
  val bookId: BookId,
  val externalId: ExternalBookId,
  val title: String,
  val imageUrl: Url.Image? = null,
  val isbn10: String? = null,
  val isbn13: String? = null,
  val pageCount: Int? = null,
  val publisher: String? = null,
  val authors: List<Author>,
  val isPinned: Boolean,
  val isFavorite: Boolean,
  val isPublic: Boolean,
  val isArchived: Boolean,
)
