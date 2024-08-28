package app.kaito_dogi.mybrary.core.api.mybrary.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostMemoRequest(
  @SerialName("my_book_id")
  val myBookId: String,
  val content: String,
  @SerialName("start_page")
  val startPage: Int?,
  @SerialName("end_page")
  val endPage: Int?,
)
