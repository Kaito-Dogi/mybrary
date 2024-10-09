package app.kaito_dogi.mybrary.core.supabase.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Memo(
  val id: String,
  @SerialName("my_book_id")
  val myBookId: String,
  val content: String,
  @SerialName("start_page")
  val startPage: Int? = null,
  @SerialName("end_page")
  val endPage: Int? = null,
  @SerialName("edited_at")
  val editedAt: String? = null,
  @SerialName("published_at")
  val publishedAt: Boolean? = null,
  @SerialName("like_count")
  val likeCount: Int,
)
