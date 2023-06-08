package app.doggy.mybrary.core.domain.model.record

import app.doggy.core.common.util.UnixTime

data class Record(
  val id: Int,
  val memo: String,
  val startPage: Int,
  val endPage: Int,
  val recordedAt: UnixTime,
)
