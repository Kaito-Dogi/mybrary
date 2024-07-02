package app.kaito_dogi.mybrary.core.data.convertor

import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MemoResponse
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.model.PageRange
import java.time.LocalDateTime

internal fun MemoResponse.toMemo() = Memo(
  id = MemoId(value = this.id),
  user = this.myBooks.user.toUser(),
  myBookId = MyBookId(value = this.myBookId),
  content = this.content,
  pageRange = this.startPage?.let {
    PageRange(
      from = it,
      to = endPage,
    )
  },
  createdAt = LocalDateTime.now(),
  updatedAt = null,
  publishedAt = null,
  likeCount = this.likeCount,
)
