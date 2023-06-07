package app.doggy.mybrary.ui.book.register

import androidx.annotation.StringRes

data class RegisterState(
  val isLoading: Boolean = false,
  val isBookRegistered: Boolean = false,
  @StringRes
  val errorMessageRes: Int? = null,
)
