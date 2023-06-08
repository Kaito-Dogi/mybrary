package app.doggy.core.network.response

import app.doggy.mybrary.core.domain.model.legacy.Book
import com.squareup.moshi.Json

class FetchBooksResponse(
  val totalItems: Int,
  val items: List<FetchBooksResponseItem>,
)

class FetchBooksResponseItem(
  @Json(name = "id")
  val booksApiId: String,
  private val volumeInfo: FetchBooksResponseVolumeInfo,
) {
  // FIXME: 変換メソッドの置き場を考える
  // TODO: thumnail が取得できなかった場合を考える
  fun toBook() = Book(
    id = null,
    booksApiId = booksApiId,
    title = volumeInfo.title,
    authors = volumeInfo.authors,
    description = volumeInfo.description ?: "",
    totalPage = volumeInfo.pageCount,
    imageUrl = volumeInfo.imageLinks.thumbnail,
    diaries = listOf(),
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
