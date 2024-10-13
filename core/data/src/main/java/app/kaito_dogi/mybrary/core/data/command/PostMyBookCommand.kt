package app.kaito_dogi.mybrary.core.data.command

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostMyBookCommand(
  @SerialName("book_id")
  val bookId: String,
  @SerialName("user_id")
  val userId: String,
)
