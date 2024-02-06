package app.doggy.mybrary.core.domain.model.book

import app.doggy.mybrary.core.common.util.UnixTime
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
) {
  companion object {
    fun createEmpty() = Book(
      id = BookId(-1),
      title = "",
      description = "",
      totalPage = BookTotalPage(1),
      imageUrl = "",
      authors = listOf(),
      registeredAt = UnixTime(0),
      isPinned = false,
      status = BookStatus.WAITING,
    )
  }
}
