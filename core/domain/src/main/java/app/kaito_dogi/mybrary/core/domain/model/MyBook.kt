package app.kaito_dogi.mybrary.core.domain.model

import app.kaito_dogi.mybrary.core.common.model.Url
import kotlinx.serialization.Serializable

@Serializable
data class MyBook(
  val id: MyBookId,
  val bookId: BookId,
  val externalId: ExternalBookId,
  val user: User,
  val title: String,
  val imageUrl: Url.Image,
  val isbn10: String,
  val isbn13: String,
  val pageCount: Int,
  val publisher: String,
  val authors: List<Author>,
  val isPinned: Boolean,
  val isFavorite: Boolean,
  val isPublic: Boolean,
  val isArchived: Boolean,
)
