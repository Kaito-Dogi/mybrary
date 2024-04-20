package app.doggy.mybrary.core.domain.legacy.model.record

import app.doggy.mybrary.core.common.util.UnixTime

data class Record(
  val id: RecordId,
  val memo: String,
  val startPage: Int,
  val endPage: Int,
  val recordedAt: UnixTime,
)
