package app.kaito_dogi.mybrary.core.data.convertor

import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MemoResponse
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.model.PageRange

internal fun MemoResponse.toMemo() = Memo(
  id = MemoId(value = this.id),
  user = this.myBook.user.toUser(),
  myBookId = MyBookId(value = this.myBookId),
  content = this.content,
  pageRange = this.startPage?.let {
    PageRange(
      from = it,
      to = endPage,
    )
  },
  createdAt = this.createdAt.toLocalDateTime(),
  updatedAt = this.editedAt?.toLocalDateTime(),
  publishedAt = this.publishedAt?.toLocalDateTime(),
  likeCount = this.likeCount,
)
