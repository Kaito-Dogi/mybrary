package app.doggy.mybrary.domain.model

import java.util.Date

data class Diary(
  val content: String,
  val currentPage: Int,
  val recordedAt: Date,
) {
  fun getPercent(totalPage: Int) = 100 * currentPage / totalPage
}
