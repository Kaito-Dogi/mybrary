package app.doggy.newmybrary.data.api.response

import java.util.Date

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
  val publisher: String,
  val publishedDate: Date,
  val description: String,
  val pageCount: Int,
  val categories: List<String>,
  val imageLinks: FetchBooksResponseImageLinks,
)

class FetchBooksResponseImageLinks(
  val smallThumbnail: String,
  val thumbnail: String,
)
