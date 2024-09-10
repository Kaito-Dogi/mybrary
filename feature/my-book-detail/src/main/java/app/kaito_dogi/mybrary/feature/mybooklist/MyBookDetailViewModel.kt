package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import app.kaito_dogi.mybrary.core.common.coroutines.LaunchSafe
import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.PageRange
import app.kaito_dogi.mybrary.core.domain.repository.DraftMemoRepository
import app.kaito_dogi.mybrary.core.domain.repository.MemoRepository
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import app.kaito_dogi.mybrary.core.ui.R
import app.kaito_dogi.mybrary.core.ui.navigation.MybraryRoute
import app.kaito_dogi.mybrary.core.ui.navigation.createTypePair
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
internal class MyBookDetailViewModel @Inject constructor(
  private val myBookRepository: MyBookRepository,
  private val memoRepository: MemoRepository,
  private val draftMemoRepository: DraftMemoRepository,
  savedStateHandle: SavedStateHandle,
  launchSafe: LaunchSafe,
) : ViewModel(), LaunchSafe by launchSafe {
  private val navArg: MybraryRoute.MyBookDetail = savedStateHandle.toRoute(
    typeMap = mapOf(
      createTypePair<MyBook>(),
    ),
  )

  private val _uiState = MutableStateFlow(
    MyBookDetailUiState.createInitialValue(
      myBook = navArg.myBook,
    ),
  )
  val uiState = _uiState.asStateFlow()

  fun onInit() {
    viewModelScope.launchSafe {
      val myBookId = navArg.myBook.id
      val memoList = memoRepository.getMemoList(myBookId = myBookId)
      val draftMemo = draftMemoRepository.getDraftMemo(
        myBookId = myBookId,
      ) ?: DraftMemo.createInitialValue(
        myBookId = myBookId,
      )
      _uiState.update {
        it.copy(
          memoList = memoList,
          draftMemo = draftMemo,
        )
      }
    }
  }

  fun onMessageShow() {
    _uiState.update { it.copy(messageResId = null) }
  }

  fun onArchiveClick() {
    viewModelScope.launchSafe {
      val archivedMyBook = myBookRepository.archiveMyBook(
        myBookId = navArg.myBook.id,
      )
      _uiState.update {
        it.copy(
          myBook = archivedMyBook,
          draftMemo = DraftMemo.createInitialValue(
            myBookId = navArg.myBook.id,
          ),
          editingMemoId = null,
          messageResId = R.string.my_book_detail_message_my_book_archived,
        )
      }
    }
  }

  fun onPublicClick() {
    viewModelScope.launchSafe {
      if (uiState.value.myBook.isPublic) {
        val privateMyBook = myBookRepository.makeMyBookPrivate(
          myBookId = navArg.myBook.id,
        )
        _uiState.update {
          it.copy(
            myBook = privateMyBook,
            messageResId = R.string.my_book_detail_message_my_book_is_now_private,
          )
        }
      } else {
        val publicMyBook = myBookRepository.makeMyBookPublic(
          myBookId = navArg.myBook.id,
        )
        _uiState.update {
          it.copy(
            myBook = publicMyBook,
            messageResId = R.string.my_book_detail_message_my_book_is_now_public,
          )
        }
      }
    }
  }

  fun onFavoriteClick() {
    viewModelScope.launchSafe {
      if (uiState.value.myBook.isFavorite) {
        val removedMyBook = myBookRepository.removeMyBookFromFavorites(
          myBookId = navArg.myBook.id,
        )
        _uiState.update {
          it.copy(
            myBook = removedMyBook,
            messageResId = R.string.my_book_detail_message_my_book_removed_from_your_favorites,
          )
        }
      } else {
        val addedMyBook = myBookRepository.addMyBookToFavorites(
          myBookId = navArg.myBook.id,
        )
        _uiState.update {
          it.copy(
            myBook = addedMyBook,
            messageResId = R.string.my_book_detail_message_my_book_added_to_your_favorites,
          )
        }
      }
    }
  }

  fun onAdditionClick() {
    viewModelScope.launchSafe {
      val myBookId = navArg.myBook.id
      val draftMemo = draftMemoRepository.getDraftMemo(
        myBookId = myBookId,
      ) ?: DraftMemo.createInitialValue(
        myBookId = myBookId,
      )

      _uiState.update {
        it.copy(
          draftMemo = draftMemo,
          isBottomSheetVisible = true,
        )
      }
    }
  }

  fun onMemoClick(memo: Memo) {
    _uiState.update {
      it.copy(
        draftMemo = it.draftMemo.copy(
          content = memo.content,
          pageRange = memo.pageRange,
        ),
        editingMemoId = memo.id,
        isBottomSheetVisible = true,
      )
    }
  }

  fun onBottomSheetDismissRequest() {
    viewModelScope.launchSafe {
      val draftMemo = uiState.value.draftMemo

      // 新規メモの編集中のみ、下書き保存する
      when {
        uiState.value.editingMemoId == null && draftMemo.content.isNotBlank() -> {
          draftMemoRepository.saveDraftMemo(draftMemo = draftMemo)
        }

        uiState.value.editingMemoId == null && draftMemo.content.isBlank() -> {
          draftMemoRepository.deleteDraftMemo(myBookId = navArg.myBook.id)
        }

        uiState.value.editingMemoId != null -> {
          // 何もしない
        }
      }

      _uiState.update {
        it.copy(
          editingMemoId = null,
          isMemoSaved = false,
          isBottomSheetVisible = false,
        )
      }
    }
  }

  fun onStartPageChange(startPage: String) {
    // 開始ページが入力された（startPage が Int に変換できる）場合、pageRange.start を更新する
    // ただし、開始ページが初めて入力された場合、新しい PageRange インスタンスを作成する
    _uiState.update { value ->
      value.copy(
        draftMemo = value.draftMemo.copy(
          pageRange = startPage.toIntOrNull()?.let {
            value.draftMemo.pageRange?.copy(
              start = it,
            ) ?: PageRange(
              start = it,
              end = null,
            )
          },
        ),
      )
    }
  }

  fun onEndPageChange(endPage: String) {
    // すでに pageRange.start が存在する場合、pageRange.end を更新する
    _uiState.update { value ->
      value.copy(
        draftMemo = value.draftMemo.copy(
          pageRange = value.draftMemo.pageRange?.copy(
            end = endPage.toIntOrNull(),
          ),
        ),
      )
    }
  }

  fun onContentChange(content: String) {
    _uiState.update {
      it.copy(
        draftMemo = it.draftMemo.copy(
          content = content,
        ),
        isContentEmptyError = false,
      )
    }
  }

  fun onSaveClick() {
    viewModelScope.launchSafe {
      // メモの内容が空の場合はエラー表示にする
      if (uiState.value.draftMemo.content.isBlank()) {
        _uiState.update { it.copy(isContentEmptyError = true) }
        return@launchSafe
      }

      val memoId = uiState.value.editingMemoId
      if (memoId == null) {
        val createdMemo = memoRepository.createMemo(draftMemo = uiState.value.draftMemo)
        draftMemoRepository.deleteDraftMemo(myBookId = navArg.myBook.id)
        _uiState.update {
          it.copy(
            memoList = it.memoList?.plus(createdMemo),
            draftMemo = DraftMemo.createInitialValue(
              myBookId = navArg.myBook.id,
            ),
            editingMemoId = null,
            isMemoSaved = true,
            messageResId = R.string.my_book_detail_message_memo_created,
          )
        }
      } else {
        val editedMemo = memoRepository.editMemo(
          memoId = memoId,
          draftMemo = uiState.value.draftMemo,
        )
        val newMemoList = uiState.value.memoList?.map {
          if (it.id == editedMemo.id) editedMemo else it
        }
        _uiState.update {
          it.copy(
            memoList = newMemoList,
            draftMemo = DraftMemo.createInitialValue(
              myBookId = navArg.myBook.id,
            ),
            editingMemoId = null,
            isMemoSaved = true,
            messageResId = R.string.my_book_detail_message_memo_edited,
          )
        }
      }
    }
  }
}
