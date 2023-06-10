package app.doggy.mybrary.ui.home

import app.doggy.mybrary.core.domain.model.legacy.LegacyBook

sealed interface HomeUiModel {
  data class BookUiModel(
    val legacyBook: LegacyBook,
    val onClick: (id: Long) -> Unit,
  ) : HomeUiModel
}
