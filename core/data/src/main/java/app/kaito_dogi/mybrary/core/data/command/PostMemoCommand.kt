package app.kaito_dogi.mybrary.core.data.command

data class PostMemoCommand(
  val myBookId: String,
  val content: String,
  val startPage: Int?,
  val endPage: Int?,
)
