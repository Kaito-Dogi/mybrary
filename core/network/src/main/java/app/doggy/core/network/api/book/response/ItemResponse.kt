package app.doggy.core.network.api.book.response

import app.doggy.core.common.util.UnixTime
import app.doggy.mybrary.core.domain.model.author.Author
import app.doggy.mybrary.core.domain.model.author.AuthorId
import app.doggy.mybrary.core.domain.model.book.Book
import app.doggy.mybrary.core.domain.model.book.BookId
import app.doggy.mybrary.core.domain.model.book.BookStatus
import app.doggy.mybrary.core.domain.model.book.BookTotalPage

internal class ItemResponse(
  private val volumeInfo: VolumeInfoResponse,
) {
  fun toBook(): Book {
    val totalPage =
      if (volumeInfo.pageCount != null && volumeInfo.pageCount > 0) BookTotalPage(volumeInfo.pageCount)
      else BookTotalPage(1)

    return Book(
      id = BookId(-1L),
      title = volumeInfo.title,
      description = volumeInfo.description ?: "",
      totalPage = totalPage,
      imageUrl = volumeInfo.imageLinks?.thumbnail ?: "",
      authors = volumeInfo.authors?.map {
        Author(
          id = AuthorId(-1L),
          name = it,
        )
      } ?: listOf(),
      registeredAt = UnixTime(0L),
      isPinned = false,
      status = BookStatus.WAITING,
    )
  }
}
