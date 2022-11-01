package app.doggy.newmybrary.domain.model

import java.time.LocalDateTime

data class Diary(
  val id: Int,
  val content: String,
  val currentPage: Int,
  val recordedAt: LocalDateTime,
)
