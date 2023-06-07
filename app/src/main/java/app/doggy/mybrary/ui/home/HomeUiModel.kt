package app.doggy.mybrary.ui.home

import app.doggy.mybrary.domain.model.Book

sealed interface HomeUiModel {
  data class BookUiModel(
    val book: Book,
    val onClick: (id: Long) -> Unit,
  ) : HomeUiModel
}
