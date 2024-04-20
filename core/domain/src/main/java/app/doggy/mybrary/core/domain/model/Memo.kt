package app.doggy.mybrary.core.domain.model

import java.util.Date

data class Memo(
  val id: MemoId,
  val myBookId: MyBookId,
  val content: String,
  val createdAt: Date,
  val postedAt: Date?,
  val interestCount: Int?,
  val likeCount: Int?,
)
