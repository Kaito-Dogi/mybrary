package app.doggy.newmybrary.domain.model

import java.util.Date

data class Book(
  val id: String,
  val title: String,
  val author: List<String>,
  val description: String,
  val totalPage: Int,
  val imageUrl: String,
  val recordList: List<Diary>,
  val registeredAt: Date?,
)
