package app.kaito_dogi.mybrary.core.data.convertor

import app.kaito_dogi.mybrary.core.database.DraftMemoEntity
import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.model.PageRange

internal fun DraftMemoEntity.toDraftMemo() = DraftMemo(
  myBookId = MyBookId(value = this.myBookId),
  content = this.content,
  pageRange = this.startPage?.let {
    PageRange(
      start = it,
      end = this.endPage,
    )
  },
)

internal fun DraftMemo.toEntity() = DraftMemoEntity(
  myBookId = this.myBookId.value,
  content = this.content,
  startPage = this.pageRange?.start,
  endPage = this.pageRange?.end,
)
