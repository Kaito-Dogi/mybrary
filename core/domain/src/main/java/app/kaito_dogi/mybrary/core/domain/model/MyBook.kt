package app.kaito_dogi.mybrary.core.domain.model

import app.kaito_dogi.mybrary.core.common.model.Url
import kotlinx.serialization.Serializable

@Serializable
data class MyBook(
  val id: MyBookId,
  val user: User,
  val bookId: BookId,
  val title: String,
  val imageUrl: Url.Image,
  val isbn: String,
  val publisher: String,
  val authorList: List<Author>,
  val genre: Genre,
  val isPinned: Boolean,
  val isFavorite: Boolean,
  val isPublic: Boolean,
  val isArchived: Boolean,
)
