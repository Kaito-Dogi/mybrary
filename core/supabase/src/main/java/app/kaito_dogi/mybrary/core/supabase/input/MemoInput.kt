package app.kaito_dogi.mybrary.core.supabase.input

import app.kaito_dogi.mybrary.core.data.command.PostMemoCommand
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MemoInput(
  @SerialName("my_book_id")
  val myBookId: String,
  val content: String,
  @SerialName("start_page")
  val startPage: Int?,
  @SerialName("end_page")
  val endPage: Int?,
)

internal fun PostMemoCommand.toMemoInput() = MemoInput(
  myBookId = this.myBookId,
  content = this.content,
  startPage = this.startPage,
  endPage = this.endPage,
)
