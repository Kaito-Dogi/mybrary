package app.kaito_dogi.mybrary.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class DraftMemo(
  val myBookId: MyBookId,
  val content: String,
  val fromPage: Int? = null,
  val toPage: Int? = null,
) {
  companion object {
    fun createInitialValue(myBookId: MyBookId) = DraftMemo(
      myBookId = myBookId,
      content = "",
      fromPage = null,
      toPage = null,
    )
  }
}
