package app.doggy.mybrary.ui.record

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.doggy.core.common.util.UnixTime
import app.doggy.mybrary.R
import app.doggy.mybrary.core.domain.model.book.BookId
import app.doggy.mybrary.core.domain.model.record.Record
import app.doggy.mybrary.core.domain.model.record.RecordId
import app.doggy.mybrary.core.domain.repository.RecordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class RecordViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle,
  private val recordRepository: RecordRepository,
) : ViewModel() {
  private val args = RecordFragmentArgs.fromSavedStateHandle(savedStateHandle)

  private val _uiState = MutableStateFlow(RecordState())
  val uiState: StateFlow<RecordState> = _uiState.asStateFlow()

  // TODO: 日記の内容を更新する処理の実装
  fun onRecordButtonClick(
    currentPage: String,
    memo: String,
  ) {
    viewModelScope.launch {
      _uiState.update { it.copy(isLoading = true) }
      runCatching {
        val isValid = currentPage.isNotBlank() && currentPage.first() != '0' && memo.isNotBlank()
        if (!isValid) throw IllegalArgumentException()

        recordRepository.record(
          record = Record(
            id = RecordId(-1),
            memo = memo,
            startPage = currentPage.toInt(),
            endPage = currentPage.toInt(),
            recordedAt = UnixTime(0),
          ),
          bookId = BookId(args.bookId),
        )
      }.onSuccess {
        _uiState.update { currentState ->
          currentState.copy(
            isLoading = false,
            isRecorded = true,
          )
        }
      }.onFailure { throwable ->
        _uiState.update { currentState ->
          currentState.copy(
            isLoading = false,
            errorMessageRes = when (throwable) {
              is IllegalArgumentException -> R.string.error_invalid_input
              else -> R.string.error_failed_to_record
            },
          )
        }
      }
    }
  }

  fun onErrorMessageShown() {
    _uiState.update { it.copy(errorMessageRes = null) }
  }
}
