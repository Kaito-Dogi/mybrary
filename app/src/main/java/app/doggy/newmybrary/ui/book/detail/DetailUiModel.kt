package app.doggy.newmybrary.ui.book.detail

import app.doggy.newmybrary.domain.model.Book
import app.doggy.newmybrary.domain.model.Diary

// FIXME: UI を Groupie で実装し、使用する
sealed interface DetailUiModel {
  data class BookUiModel(
    val book: Book,
  ) : DetailUiModel

  data class DiaryUiModel(
    val diary: Diary,
  ) : DetailUiModel
}
