package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.domain.model.Draft
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.MyBook

@Immutable
internal data class MyBookDetailUiState(
  val myBook: MyBook,
  val memoList: List<Memo>?,
  val isBottomSheetVisible: Boolean,
  val editedMemoId: MemoId?,
  val draftMemo: Draft,
  val isContentEmptyError: Boolean,
  val shownMessage: String?,
) {
  companion object {
    fun createInitialValue(myBook: MyBook) = MyBookDetailUiState(
      myBook = myBook,
      memoList = null,
      isBottomSheetVisible = false,
      editedMemoId = null,
      draftMemo = Draft(
        myBookId = myBook.id,
        content = "",
        fromPage = null,
        toPage = null,
      ),
      isContentEmptyError = false,
      shownMessage = null,
    )
  }
}
