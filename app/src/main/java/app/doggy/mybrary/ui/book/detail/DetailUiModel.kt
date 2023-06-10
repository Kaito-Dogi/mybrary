package app.doggy.mybrary.ui.book.detail

import app.doggy.mybrary.core.domain.model.book.Book
import app.doggy.mybrary.core.domain.model.record.Record

// FIXME: UI を Groupie で実装し、使用する
sealed interface DetailUiModel {
  data class BookUiModel(
    val book: Book,
  ) : DetailUiModel

  data class RecordUiModel(
    val record: Record,
  ) : DetailUiModel
}
