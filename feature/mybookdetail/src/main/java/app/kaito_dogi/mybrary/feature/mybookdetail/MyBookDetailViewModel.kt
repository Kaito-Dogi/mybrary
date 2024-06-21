package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.repository.MemoRepository
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDateTime
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
  private val navArg: MyBookDetailNavArg = checkNotNull(savedStateHandle[myBookDetailNavArgName])

  private val _uiState = MutableStateFlow(
    MyBookDetailUiState.createInitialValue(
      myBook = navArg.myBook,
    ),
  )
  val uiState = _uiState.asStateFlow()

  fun init() {
    viewModelScope.launch {
      try {
        val memoList = memoRepository.getMemos(navArg.myBook.id)
        _uiState.update { it.copy(memoList = memoList) }
      } catch (e: Exception) {
        // TODO: デバッグ用のログを実装する
        println("あああ: ${e.message}")
      }
    }
  }

  fun onArchiveClick() {
    viewModelScope.launch {
      try {
        myBookRepository.archiveBook(navArg.myBook.id)
      } catch (e: Exception) {
        // TODO: デバッグ用のログを実装する
        println("あああ: ${e.message}")
      }
    }
  }

  fun onFavoriteClick() {
    viewModelScope.launch {
      try {
        val myBook = myBookRepository.makeBookFavorite(navArg.myBook.id)
        _uiState.update { it.copy(myBook = myBook) }
      } catch (e: Exception) {
        // TODO: デバッグ用のログを実装する
        println("あああ: ${e.message}")
      }
    }
  }

  fun onEditClick() {
    _uiState.update { it.copy(isBottomSheetVisible = true) }
  }

  fun onMemoClick(memo: Memo) {
    _uiState.update {
      it.copy(
        isBottomSheetVisible = true,
        memoFromPage = memo.fromPage.toString(),
        memoToPage = memo.toPage.toString(),
        memoContent = memo.content,
      )
    }
  }

  fun onBottomSheetDismissRequest() {
    _uiState.update { it.copy(isBottomSheetVisible = false) }
  }

  fun onFromPageChange(fromPage: String) {
    _uiState.update { it.copy(memoFromPage = fromPage) }
  }

  fun onToPageChange(toPage: String) {
    _uiState.update { it.copy(memoToPage = toPage) }
  }

  fun onContentChange(content: String) {
    _uiState.update { it.copy(memoContent = content) }
  }

  fun onSaveClick() {
    viewModelScope.launch {
      try {
        memoRepository.createMemo(
          memo = Memo(
            id = MemoId(0L),
            myBookId = navArg.myBook.id,
            content = uiState.value.memoContent,
            fromPage = uiState.value.memoFromPage.toInt(),
            toPage = if (uiState.value.memoToPage.isBlank()) uiState.value.memoToPage.toInt() else null,
            createdAt = LocalDateTime.now(),
            isPosted = false,
            postedAt = null,
            likeCount = null,
          ),
        )
        _uiState.update {
          it.copy(
            memoFromPage = "",
            memoToPage = "",
            memoContent = "",
          )
        }
      } catch (e: Exception) {
        // TODO: デバッグ用のログを実装する
        println("あああ: ${e.message}")
      }
    }
  }
}
