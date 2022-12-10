package app.doggy.newmybrary.ui.diary.record

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import app.doggy.newmybrary.domain.repository.DiaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecordViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle,
  private val diaryRepository: DiaryRepository,
) : ViewModel() {
  private val args = RecordFragmentArgs.fromSavedStateHandle(savedStateHandle)
}
