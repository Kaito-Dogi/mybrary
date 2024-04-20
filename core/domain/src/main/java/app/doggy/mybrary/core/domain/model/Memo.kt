package app.doggy.mybrary.core.domain.model

import java.util.Date

data class Memo(
  val id: MemoId,
  val myBookId: MyBookId,
  val content: String,
  val fromPage: Int?,
  val toPage: Int?,
  val createdAt: Date,
  val isPosted: Boolean,
  val postedAt: Date?,
  val likeCount: Int?,
)
