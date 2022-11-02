package app.doggy.newmybrary.data.api.response

import java.time.LocalDateTime

class FetchBooksResponse(
  val totalItems: Int,
  val items: List<FetchBookResponseItem>,
)

class FetchBookResponseItem(
  val id: String,
  val volumeInfo: FetchBookResponseVolumeInfo,
)

class FetchBookResponseVolumeInfo(
  val title: String,
  val authors: List<String>,
  val publisher: String,
  val publishedDate: LocalDateTime,
  val description: String,
  val pageCount: Int,
  val categories: List<String>,
  val imageLinks: FetchBookResponseImageLinks,
)

class FetchBookResponseImageLinks(
  smallThumbnail: String,
  thumbnail: String,
)
