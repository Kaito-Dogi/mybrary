package app.doggy.mybrary.ui.book.detail

import androidx.annotation.StringRes
import app.doggy.mybrary.core.domain.model.book.Book

data class DetailState(
  val book: Book = Book.createEmpty(),
  val isLoading: Boolean = false,
  @StringRes
  val errorMessageRes: Int? = null,
)
