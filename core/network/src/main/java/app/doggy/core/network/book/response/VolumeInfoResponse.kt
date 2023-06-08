package app.doggy.core.network.book.response

class VolumeInfoResponse(
  val title: String,
  val authors: List<String>?,
  val description: String?,
  val pageCount: Int?,
  val imageLinks: ImageLinksResponse?,
)
