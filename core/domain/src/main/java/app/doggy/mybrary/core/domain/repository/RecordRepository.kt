package app.doggy.mybrary.core.domain.repository

import app.doggy.mybrary.core.domain.model.book.BookId
import app.doggy.mybrary.core.domain.model.record.Record
import app.doggy.mybrary.core.domain.model.record.RecordId
import kotlinx.coroutines.flow.Flow

interface RecordRepository {

  suspend fun record(
    record: Record,
    bookId: BookId,
  )

  suspend fun updateRecord(
    record: Record,
    bookId: BookId,
  )

  suspend fun deleteRecord(recordId: RecordId)

  fun getRecord(recordId: RecordId): Flow<Record>
}
