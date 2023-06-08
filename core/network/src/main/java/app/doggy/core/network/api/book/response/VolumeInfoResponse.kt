package app.doggy.core.network.api.book.response

class VolumeInfoResponse(
  val title: String,
  val authors: List<String>?,
  val description: String?,
  val pageCount: Int?,
  val imageLinks: ImageLinksResponse?,
)
