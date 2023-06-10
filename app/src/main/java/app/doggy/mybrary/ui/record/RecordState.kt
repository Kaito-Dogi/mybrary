package app.doggy.mybrary.ui.record

import androidx.annotation.StringRes

data class RecordState(
  val isLoading: Boolean = false,
  val isRecorded: Boolean = false,
  @StringRes
  val errorMessageRes: Int? = null,
)
