package app.doggy.mybrary.core.domain.model.legacy

import java.util.Date

data class LegacyDiary(
  val content: String,
  val currentPage: Int,
  val recordedAt: Date,
) {
  fun getPercent(totalPage: Int) = 100 * currentPage / totalPage
}
