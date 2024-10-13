package app.kaito_dogi.mybrary.core.data.dto

// FIXME: ユーザー情報を含めるようにする
data class MemoDto(
  val memoId: String,
  val content: String,
  val startPage: Int?,
  val endPage: Int?,
  val createdAt: String,
  val editedAt: String?,
  val publishedAt: String?,
  val likeCount: Int,
)
