package app.kaito_dogi.mybrary.core.data.command

data class PostBookCommand(
  val title: String,
  val imageUrl: String,
  val authors: String,
  val publisher: String,
  val isbn: String,
  val genre: Int,
  val rakutenUrl: String,
)
