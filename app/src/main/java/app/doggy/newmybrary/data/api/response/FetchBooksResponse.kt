package app.doggy.newmybrary.data.api.response

import app.doggy.newmybrary.domain.model.Book

class FetchBooksResponse(
  val totalItems: Int,
  val items: List<FetchBooksResponseItem>,
)

class FetchBooksResponseItem(
  val id: String,
  val volumeInfo: FetchBooksResponseVolumeInfo,
)

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

// FIXME: 変換メソッドの置き場を考える
fun FetchBooksResponseItem.toBook() = Book(
  id = this.id,
  title = this.volumeInfo.title,
  author = this.volumeInfo.authors,
  description = this.volumeInfo.description ?: "",
  totalPage = this.volumeInfo.pageCount,
  imageUrl = this.volumeInfo.imageLinks.thumbnail,
  recordList = listOf(),
  registeredAt = null,
)
