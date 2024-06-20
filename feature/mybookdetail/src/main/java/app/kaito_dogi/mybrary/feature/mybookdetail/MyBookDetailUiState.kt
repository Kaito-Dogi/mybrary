package app.kaito_dogi.mybrary.feature.mybookdetail

import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MyBook

internal data class MyBookDetailUiState(
  val myBook: MyBook,
  val memos: List<Memo>?,
) {
  companion object {
    fun createInitialValue(
      myBook: MyBook,
    ) = MyBookDetailUiState(
        myBook = myBook,
        memos = null,
    )
  }
}
