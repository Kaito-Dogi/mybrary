package app.kaito_dogi.mybrary.core.data.dto

import app.kaito_dogi.mybrary.core.common.ext.toLocalDateTime
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.PageRange

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
) {
  fun toMemo() = Memo(
    id = MemoId(value = this.memoId),
    content = this.content,
    pageRange = this.startPage?.let {
      PageRange(
        start = it,
        end = endPage,
      )
    },
    createdAt = this.createdAt.toLocalDateTime(),
    editedAt = this.editedAt?.toLocalDateTime(),
    publishedAt = this.publishedAt?.toLocalDateTime(),
    likeCount = this.likeCount,
  )
}
