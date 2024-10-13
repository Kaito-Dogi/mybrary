package app.kaito_dogi.mybrary.core.data.dto

data class BookDto(
  val bookId: String,
  val title: String,
  val imageUrl: String,
  val authors: String,
  val publisher: String,
  val isbn: String,
  val genre: Int,
  val rakutenUrl: String,
  val amazonUrl: String?,
)
