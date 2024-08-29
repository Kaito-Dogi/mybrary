package app.kaito_dogi.mybrary.core.api.mybrary.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostMyBookRequest(
  @SerialName("book_id")
  val bookId: String,
)
