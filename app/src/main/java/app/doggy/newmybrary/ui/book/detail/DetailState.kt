package app.doggy.newmybrary.ui.book.detail

import androidx.annotation.StringRes

data class DetailState(
  val uiModels: List<DetailUiModel> = listOf(),
  val isLoading: Boolean = false,
  @StringRes
  val errorMessageRes: Int? = null,
)
