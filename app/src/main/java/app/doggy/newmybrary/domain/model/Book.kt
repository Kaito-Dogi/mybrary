package app.doggy.newmybrary.domain.model

import java.time.LocalDateTime

data class Book(
  val id: Int,
  val title: String,
  val author: String,
  val description: String,
  val totalPage: Int,
  val imageUrl: String,
  val recordList: List<Diary>,
  val registeredAt: LocalDateTime,
)
