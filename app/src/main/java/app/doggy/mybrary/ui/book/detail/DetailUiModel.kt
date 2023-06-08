package app.doggy.mybrary.ui.book.detail

import app.doggy.mybrary.core.domain.model.legacy.Book
import app.doggy.mybrary.core.domain.model.Diary

// FIXME: UI を Groupie で実装し、使用する
sealed interface DetailUiModel {
  data class BookUiModel(
    val book: Book,
  ) : DetailUiModel

  data class DiaryUiModel(
    val diary: Diary,
  ) : DetailUiModel
}
