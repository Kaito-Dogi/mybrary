package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.repository.MemoRepository
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
internal class MyBookDetailViewModel @Inject constructor(
  private val myBookRepository: MyBookRepository,
  private val memoRepository: MemoRepository,
  savedStateHandle: SavedStateHandle,
) : ViewModel() {
  private val navArg: MyBookDetailNavArg = checkNotNull(savedStateHandle[MyBookDetailNavArgName])

  private val _uiState = MutableStateFlow(
    MyBookDetailUiState.createInitialValue(
      myBook = navArg.myBook,
    ),
  )
  val uiState = _uiState.asStateFlow()

  fun init() {
    viewModelScope.launch {
      try {
        val memoList = memoRepository.getMemoList(navArg.myBook.id)
        _uiState.update { it.copy(memoList = memoList) }
      } catch (e: Exception) {
        // TODO: デバッグ用のログを実装する
        println("あああ: ${e.message}")
      }
    }
  }

  fun onMessageShow() {
    _uiState.update { it.copy(shownMessage = null) }
  }

  fun onArchiveClick() {
    viewModelScope.launch {
      try {
        val archivedMyBook = myBookRepository.archiveMyBook(navArg.myBook.id)
        _uiState.update {
          it.copy(
            myBook = archivedMyBook,
            editingMemoId = null,
            draftMemo = DraftMemo.createInitialValue(navArg.myBook.id),
            shownMessage = "『${archivedMyBook.title}』をアーカイブしました",
          )
        }
      } catch (e: Exception) {
        // TODO: デバッグ用のログを実装する
        println("あああ: ${e.message}")
      }
    }
  }

  fun onPublicClick() {
    viewModelScope.launch {
      try {
        if (uiState.value.myBook.isPublic) {
          val privateMyBook = myBookRepository.makeMyBookPrivate(navArg.myBook.id)
          _uiState.update {
            it.copy(
              myBook = privateMyBook,
              shownMessage = "『${privateMyBook.title}』を非公開にしました",
            )
          }
        } else {
          val publicMyBook = myBookRepository.makeMyBookPublic(navArg.myBook.id)
          _uiState.update {
            it.copy(
              myBook = publicMyBook,
              shownMessage = "『${publicMyBook.title}』を公開しました",
            )
          }
        }
      } catch (e: Exception) {
        // TODO: デバッグ用のログを実装する
        println("あああ: ${e.message}")
      }
    }
  }

  fun onFavoriteClick() {
    viewModelScope.launch {
      try {
        if (uiState.value.myBook.isFavorite) {
          val removedMyBook = myBookRepository.removeMyBookFromFavorites(navArg.myBook.id)
          _uiState.update {
            it.copy(
              myBook = removedMyBook,
              shownMessage = "『${removedMyBook.title}』をお気に入りから削除しました",
            )
          }
        } else {
          val addedMyBook = myBookRepository.addMyBookToFavorites(navArg.myBook.id)
          _uiState.update {
            it.copy(
              myBook = addedMyBook,
              shownMessage = "『${addedMyBook.title}』をお気に入りに追加しました",
            )
          }
        }
      } catch (e: Exception) {
        // TODO: デバッグ用のログを実装する
        println("あああ: ${e.message}")
      }
    }
  }

  fun onAdditionClick() {
    _uiState.update { it.copy(isBottomSheetVisible = true) }
  }

  fun onMemoClick(memo: Memo) {
    _uiState.update {
      it.copy(
        isBottomSheetVisible = true,
        editingMemoId = memo.id,
        draftMemo = it.draftMemo.copy(
          content = memo.content,
          fromPage = memo.fromPage,
          toPage = memo.toPage,
        ),
      )
    }
  }

  fun onBottomSheetDismissRequest() {
    _uiState.update {
      it.copy(
        isBottomSheetVisible = false,
        editingMemoId = null,
        draftMemo = if (it.editingMemoId == null) {
          it.draftMemo
        } else {
          DraftMemo.createInitialValue(
            navArg.myBook.id,
          )
        },
      )
    }
  }

  fun onFromPageChange(fromPage: String) {
    _uiState.update {
      it.copy(
        draftMemo = it.draftMemo.copy(
          fromPage = if (fromPage.isNotBlank()) fromPage.toInt() else null,
        ),
      )
    }
  }

  fun onToPageChange(toPage: String) {
    _uiState.update {
      it.copy(
        draftMemo = it.draftMemo.copy(
          toPage = if (toPage.isNotBlank()) toPage.toInt() else null,
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

  fun onSaveClick(
    onComplete: () -> Unit,
  ) {
    viewModelScope.launch {
      try {
        // メモの内容が空の場合はエラー表示にする
        if (uiState.value.draftMemo.content.isBlank()) {
          _uiState.update { it.copy(isContentEmptyError = true) }
          return@launch
        }

        val memoId = uiState.value.editingMemoId
        if (memoId == null) {
          val createdMemo = memoRepository.createMemo(
            draftMemo = uiState.value.draftMemo,
          )
          _uiState.update {
            it.copy(
              memoList = it.memoList?.plus(createdMemo),
              editingMemoId = null,
              draftMemo = DraftMemo.createInitialValue(navArg.myBook.id),
              shownMessage = "メモを追加しました",
            )
          }
        } else {
          val updatedMemo = memoRepository.updateMemo(
            memoId = memoId,
            draftMemo = uiState.value.draftMemo,
          )
          val newMemoList = uiState.value.memoList?.map {
            if (it.id == updatedMemo.id) updatedMemo else it
          }
          _uiState.update {
            it.copy(
              memoList = newMemoList,
              editingMemoId = null,
              draftMemo = DraftMemo.createInitialValue(navArg.myBook.id),
              shownMessage = "メモを編集しました",
            )
          }
        }

        // BottomSheet を閉じる
        onComplete()
      } catch (e: Exception) {
        // TODO: デバッグ用のログを実装する
        println("あああ: ${e.message}")
      }
    }
  }
}
