package app.kaito_dogi.mybrary.core.domain.model

import app.kaito_dogi.mybrary.core.common.model.Url
import kotlinx.serialization.Serializable

@Serializable
data class MyBook(
  val id: MyBookId,
  val externalId: String,
  val title: String,
  val authors: String,
  val imageUrl: Url.Image,
  val isPinned: Boolean,
  val isFavorite: Boolean,
  val isArchived: Boolean,
  val memos: List<Memo>,
)
