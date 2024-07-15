package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.MyBook

@Immutable
internal data class MyBookDetailUiState(
  val myBook: MyBook,
  val memoList: List<Memo>?,
  val isBottomSheetVisible: Boolean,
  val editingMemoId: MemoId?,
  val draftMemo: DraftMemo,
  val isMemoSaved: Boolean,
  val isContentEmptyError: Boolean,
  val shownMessage: String?,
) {
  companion object {
    fun createInitialValue(myBook: MyBook) = MyBookDetailUiState(
      myBook = myBook,
      memoList = null,
      isBottomSheetVisible = false,
      editingMemoId = null,
      draftMemo = DraftMemo(
        myBookId = myBook.id,
        content = "",
        pageRange = null,
      ),
      isMemoSaved = false,
      isContentEmptyError = false,
      shownMessage = null,
    )
  }
}
