package app.doggy.mybrary.ui.book.detail

import androidx.annotation.StringRes
import app.doggy.mybrary.domain.model.Book

data class DetailState(
  // FIXME: UI を Groupie で実装し、DetailUiModel の List に置き換える
  val book: Book = Book.createEmpty(),
  val isLoading: Boolean = false,
  @StringRes
  val errorMessageRes: Int? = null,
)
