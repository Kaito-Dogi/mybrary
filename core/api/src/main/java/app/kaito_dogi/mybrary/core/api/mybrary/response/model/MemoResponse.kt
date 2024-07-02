package app.kaito_dogi.mybrary.core.api.mybrary.response.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MemoResponse(
  val id: Long,
  @SerialName("my_book_id") val myBookId: Long,
  val content: String,
  @SerialName("start_page") val startPage: Int? = null,
  @SerialName("end_page") val endPage: Int? = null,
  @SerialName("edited_at") val editedAt: String? = null,
  @SerialName("published_at") val publishedAt: String? = null,
  @SerialName("like_count") val likeCount: Int,
  @SerialName("created_at") val createdAt: String,
  @SerialName("my_books") val myBook: MyBookUserResponse,
)
