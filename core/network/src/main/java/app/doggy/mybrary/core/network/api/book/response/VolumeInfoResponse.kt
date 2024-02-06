package app.doggy.mybrary.core.network.api.book.response

internal class VolumeInfoResponse(
  val title: String,
  val authors: List<String>?,
  val description: String?,
  val pageCount: Int?,
  val imageLinks: ImageLinksResponse?,
)
