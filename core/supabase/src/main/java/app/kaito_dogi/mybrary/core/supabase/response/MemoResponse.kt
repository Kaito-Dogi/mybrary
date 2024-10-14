package app.kaito_dogi.mybrary.core.supabase.response

import app.kaito_dogi.mybrary.core.data.dto.MemoDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MemoResponse(
  val id: String,
  @SerialName("my_book_id")
  val myBookId: String,
  val content: String,
  @SerialName("start_page")
  val startPage: Int? = null,
  @SerialName("end_page")
  val endPage: Int? = null,
  @SerialName("created_at")
  val createdAt: String,
  @SerialName("edited_at")
  val editedAt: String? = null,
  @SerialName("published_at")
  val publishedAt: String? = null,
  @SerialName("like_count")
  val likeCount: Int,
) {
  fun toMemoDto() = MemoDto(
    id = this.id,
    content = this.content,
    startPage = this.startPage,
    endPage = this.endPage,
    createdAt = this.createdAt,
    editedAt = this.editedAt,
    publishedAt = this.publishedAt,
    likeCount = this.likeCount,
  )
}
