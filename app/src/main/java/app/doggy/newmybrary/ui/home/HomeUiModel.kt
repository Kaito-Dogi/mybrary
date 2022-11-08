package app.doggy.newmybrary.ui.home

import app.doggy.newmybrary.domain.model.Book

sealed interface HomeUiModel {
  data class BookUiModel(
    val book: Book,
    val onClick: (id: Long) -> Unit,
  ) : HomeUiModel
}
