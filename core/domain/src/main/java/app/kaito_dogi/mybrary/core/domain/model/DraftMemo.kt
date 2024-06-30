package app.kaito_dogi.mybrary.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class DraftMemo(
  val myBookId: MyBookId,
  val content: String,
  val pageRange: PageRange? = null,
) {
  companion object {
    fun createInitialValue(myBookId: MyBookId) = DraftMemo(
      myBookId = myBookId,
      content = "",
      pageRange = null,
    )
  }
}
