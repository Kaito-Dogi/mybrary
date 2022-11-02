package app.doggy.newmybrary.domain.model

import java.util.Date

data class Diary(
  val content: String,
  val currentPage: Int,
  val recordedAt: Date,
)
