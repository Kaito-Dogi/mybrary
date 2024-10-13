package app.kaito_dogi.mybrary.core.supabase.mybook

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MyBookInput(
  @SerialName("book_id")
  val bookId: String,
  @SerialName("user_id")
  val userId: String,
)
