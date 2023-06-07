package app.doggy.mybrary.ui.diary.record

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.doggy.mybrary.R
import app.doggy.mybrary.core.domain.model.Diary
import app.doggy.mybrary.domain.repository.DiaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Date
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class RecordViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle,
  private val diaryRepository: DiaryRepository,
) : ViewModel() {
  private val args = RecordFragmentArgs.fromSavedStateHandle(savedStateHandle)

  private val _uiState = MutableStateFlow(RecordState())
  val uiState: StateFlow<RecordState> = _uiState.asStateFlow()

  // TODO: 日記の内容を更新する処理の実装
  fun onRecordButtonClick(
    currentPage: String,
    content: String,
  ) {
    viewModelScope.launch {
      _uiState.update { it.copy(isLoading = true) }
      runCatching {
        val isValid = currentPage.isNotBlank() && currentPage.first() != '0' && content.isNotBlank()
        if (!isValid) throw IllegalArgumentException()

        diaryRepository.recordDiary(
          diary = Diary(
            content = content,
            currentPage = currentPage.toInt(),
            recordedAt = Date(),
          ),
          bookId = args.bookId,
        )
      }.onSuccess {
        _uiState.update { currentState ->
          currentState.copy(
            isLoading = false,
            isDiaryRecorded = true,
          )
        }
      }.onFailure { throwable ->
        _uiState.update { currentState ->
          currentState.copy(
            isLoading = false,
            errorMessageRes = when (throwable) {
              is IllegalArgumentException -> R.string.error_invalid_input
              else -> R.string.error_failed_to_record_diary
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
