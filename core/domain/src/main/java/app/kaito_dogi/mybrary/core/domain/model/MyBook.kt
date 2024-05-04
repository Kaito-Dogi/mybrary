package app.kaito_dogi.mybrary.core.domain.model

data class MyBook(
  val id: MyBookId,
  val externalId: String,
  val title: String,
  val author: String,
  val imageUrl: String,
  val isPinned: Boolean,
  val isFavorite: Boolean,
  val isArchived: Boolean,
  val memos: List<Memo>,
)
