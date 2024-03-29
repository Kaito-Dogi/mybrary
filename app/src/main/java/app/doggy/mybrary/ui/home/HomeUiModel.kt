package app.doggy.mybrary.ui.home

import app.doggy.mybrary.core.domain.model.book.Book

sealed interface HomeUiModel {
  data class BookUiModel(
    val book: Book,
    val onClick: (id: Long) -> Unit,
  ) : HomeUiModel
}
