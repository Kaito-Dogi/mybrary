package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MyBook

@Immutable
internal data class MyBookDetailUiState(
  val myBook: MyBook,
  val memoList: List<Memo>?,
  val isBottomSheetVisible: Boolean,
  val memoFromPage: String,
  val memoToPage: String,
  val memoContent: String,
) {
  companion object {
    fun createInitialValue(
      myBook: MyBook,
    ) = MyBookDetailUiState(
      myBook = myBook,
      memoList = null,
      isBottomSheetVisible = false,
      memoFromPage = "",
      memoToPage = "",
      memoContent = "",
    )
  }
}
