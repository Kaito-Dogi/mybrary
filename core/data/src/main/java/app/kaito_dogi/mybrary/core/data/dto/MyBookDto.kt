package app.kaito_dogi.mybrary.core.data.dto

data class MyBookDto(
  val myBookId: String,
  val title: String,
  val imageUrl: String,
  val authors: String,
  val publisher: String,
  val isbn: String,
  val genre: Int,
  val isPinned: Boolean,
  val isFavorite: Boolean,
  val isPublic: Boolean,
  val isArchived: Boolean,
)
