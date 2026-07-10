package app.kaito_dogi.mybrary.core.domain.model

import kotlinx.serialization.Serializable

/**
 * メモの下書き
 *
 * @property myBookId 下書き先の [MyBook] の ID
 * @property content メモの内容
 * @property pageRange メモ対象のページ範囲
 */
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
