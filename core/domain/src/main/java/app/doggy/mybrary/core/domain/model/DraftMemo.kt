package app.doggy.mybrary.core.domain.model

data class DraftMemo(
  val myBookId: MyBookId,
  val content: String,
  val fromPage: Int?,
  val toPage: Int?,
)
