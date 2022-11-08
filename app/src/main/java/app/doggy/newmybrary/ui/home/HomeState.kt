package app.doggy.newmybrary.ui.home

import androidx.annotation.StringRes

data class HomeState(
  val uiModels: List<HomeUiModel> = listOf(),
  val isLoading: Boolean = false,
  val clickedBookId: Long? = null,
  @StringRes
  val errorMessageRes: Int? = null,
)
