package app.doggy.mybrary.core.domain.model.book

import app.doggy.core.common.util.UnixTime
import app.doggy.mybrary.core.domain.model.author.Author

data class Book(
  val id: BookId,
  val title: String,
  val description: String,
  val totalPage: BookTotalPage,
  val imageUrl: String,
  val authors: List<Author>,
  val registeredAt: UnixTime,
  val isPinned: Boolean,
  val status: BookStatus,
)
