package app.kaito_dogi.mybrary.core.data.convertor

import app.kaito_dogi.mybrary.core.database.local.DraftMemoEntity
import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.MyBookId

internal fun DraftMemoEntity.toDraftMemo() = DraftMemo(
  myBookId = MyBookId(value = myBookId),
  content = content,
  fromPage = fromPage,
  toPage = toPage,
)

internal fun DraftMemo.toEntity() = DraftMemoEntity(
  myBookId = myBookId.value,
  content = content,
  fromPage = fromPage,
  toPage = toPage,
)
