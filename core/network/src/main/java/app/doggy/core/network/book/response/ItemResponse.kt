package app.doggy.core.network.book.response

import app.doggy.core.common.UnixTime
import app.doggy.mybrary.core.domain.model.book.Author
import app.doggy.mybrary.core.domain.model.book.Book
import app.doggy.mybrary.core.domain.model.book.BookStatus
import app.doggy.mybrary.core.domain.model.book.BookTotalPage

class ItemResponse(
  val id: String,
  private val volumeInfo: VolumeInfoResponse,
) {
  fun toBook() = Book(
    id = 0,
    name = volumeInfo.title,
    description = volumeInfo.description ?: "",
    totalPage = BookTotalPage(volumeInfo.pageCount),
    imageUrl = volumeInfo.imageLinks.thumbnail,
    authors = volumeInfo.authors.map {
      Author(
        id = 0,
        name = it,
      )
    },
    registeredAt = UnixTime(0L),
    isPinned = false,
    status = BookStatus.WAITING,
  )
}
