package app.kaito_dogi.mybrary.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Draft(
  val myBookId: MyBookId,
  val content: String,
  val fromPage: Int?,
  val toPage: Int?,
) {
  companion object {
    fun createInitialValue(myBookId: MyBookId) = Draft(
      myBookId = myBookId,
      content = "",
      fromPage = null,
      toPage = null,
    )
  }
}
