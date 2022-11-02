package app.doggy.newmybrary.data.api.response

import app.doggy.newmybrary.domain.model.Book

class FetchBooksResponse(
  val totalItems: Int,
  val items: List<FetchBooksResponseItem>,
)

class FetchBooksResponseItem(
  val id: String,
  val volumeInfo: FetchBooksResponseVolumeInfo,
) {
  // FIXME: 変換メソッドの置き場を考える
  fun toBook() = Book(
    id = id,
    title = volumeInfo.title,
    author = volumeInfo.authors,
    description = volumeInfo.description ?: "",
    totalPage = volumeInfo.pageCount,
    imageUrl = volumeInfo.imageLinks.thumbnail,
    recordList = listOf(),
    registeredAt = null,
  )
}

class FetchBooksResponseVolumeInfo(
  val title: String,
  val authors: List<String>,
  val publisher: String?,
  val publishedDate: String,
  val description: String?,
  val pageCount: Int,
  val categories: List<String>?,
  val imageLinks: FetchBooksResponseImageLinks,
)

class FetchBooksResponseImageLinks(
  val smallThumbnail: String,
  val thumbnail: String,
)
