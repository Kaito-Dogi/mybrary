package app.doggy.mybrary.ui.book.detail

import app.doggy.mybrary.core.domain.model.legacy.LegacyBook
import app.doggy.mybrary.core.domain.model.legacy.LegacyDiary

// FIXME: UI を Groupie で実装し、使用する
sealed interface DetailUiModel {
  data class BookUiModel(
    val legacyBook: LegacyBook,
  ) : DetailUiModel

  data class DiaryUiModel(
    val legacyDiary: LegacyDiary,
  ) : DetailUiModel
}
