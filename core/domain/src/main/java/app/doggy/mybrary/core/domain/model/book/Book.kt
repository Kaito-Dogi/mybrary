package app.doggy.mybrary.core.domain.model.book

import app.doggy.core.common.UnixTime

data class Book(
  val id: Int,
  val name: String,
  val description: String,
  val totalPage: BookTotalPage,
  val imageUrl: String,
  val authors: List<Author>,
  val registeredAt: UnixTime,
  val isPinned: Boolean,
  val status: BookStatus,
)
