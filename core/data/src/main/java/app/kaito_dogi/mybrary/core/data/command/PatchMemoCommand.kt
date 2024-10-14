package app.kaito_dogi.mybrary.core.data.command

data class PatchMemoCommand(
  val memoId: String,
  val content: String,
  val startPage: Int?,
  val endPage: Int?,
)
