package app.kaito_dogi.mybrary.core.data.command

data class PostMyBookCommand(
  val bookId: String,
  val userId: String,
)
