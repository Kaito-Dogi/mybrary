package app.kaito_dogi.mybrary.feature.mybook.route.mybookdetail

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.MyBook

@Immutable
internal data class MyBookDetailUiState(
  val myBook: MyBook,
  val memoList: List<Memo>?,
  val draftMemo: DraftMemo,
  val editingMemoId: MemoId?,
  val isMemoSaved: Boolean,
  val isContentEmptyError: Boolean,
  val isBottomSheetVisible: Boolean,
  @StringRes val messageResId: Int?,
) {
  companion object {
    fun createInitialValue(myBook: MyBook) = MyBookDetailUiState(
      myBook = myBook,
      memoList = null,
      draftMemo = DraftMemo(
        myBookId = myBook.id,
        content = "",
        pageRange = null,
      ),
      editingMemoId = null,
      isMemoSaved = false,
      isContentEmptyError = false,
      isBottomSheetVisible = false,
      messageResId = null,
    )
  }
}
