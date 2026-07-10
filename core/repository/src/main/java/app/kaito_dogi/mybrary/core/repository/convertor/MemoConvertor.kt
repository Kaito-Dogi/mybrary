package app.kaito_dogi.mybrary.core.repository.convertor

import app.kaito_dogi.mybrary.core.database.MemoEntity
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.PageRange
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

internal fun MemoEntity.toMemo() = Memo(
  id = MemoId(value = this.id),
  content = this.content,
  pageRange = this.startPage?.let {
    PageRange(
      start = it,
      end = this.endPage,
    )
  },
  createdAt = this.createdAt.toLocalDateTime(),
  editedAt = this.editedAt?.toLocalDateTime(),
)

private fun Long.toLocalDateTime(): LocalDateTime = LocalDateTime.ofInstant(
  Instant.ofEpochMilli(this),
  ZoneId.systemDefault(),
)
