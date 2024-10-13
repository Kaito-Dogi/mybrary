package app.kaito_dogi.mybrary.core.supabase.input

import app.kaito_dogi.mybrary.core.data.command.PostMyBookCommand
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MyBookInput(
  @SerialName("book_id")
  val bookId: String,
  @SerialName("user_id")
  val userId: String,
)

internal fun PostMyBookCommand.toMyBookInput() = MyBookInput(
  bookId = this.bookId,
  userId = this.userId,
)
