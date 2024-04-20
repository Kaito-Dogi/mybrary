package app.doggy.mybrary.core.network.api.book.response

import app.doggy.mybrary.core.domain.model.Book

internal class ItemResponse(
  private val volumeInfo: VolumeInfoResponse,
) {
  fun toBook(): Book {
    return Book(
      id = "",
      title = volumeInfo.title,
      author = volumeInfo.authors?.joinToString(", ") ?: "",
      imageUrl = volumeInfo.imageLinks?.thumbnail ?: "",
    )
  }
}
