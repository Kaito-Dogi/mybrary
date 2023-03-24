package app.doggy.newmybrary.ui.diary.record

import androidx.annotation.StringRes

data class RecordState(
  val isLoading: Boolean = false,
  val isDiaryRecorded: Boolean = false,
  @StringRes
  val errorMessageRes: Int? = null,
)
