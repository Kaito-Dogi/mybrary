package app.doggy.mybrary.core.domain.repository

import app.doggy.mybrary.core.domain.model.record.Record
import kotlinx.coroutines.flow.Flow

interface RecordRepository {

  suspend fun record(record: Record)

  suspend fun updateRecord(record: Record)

  suspend fun deleteRecord(recordId: Long)

  fun getRecords(bookId: Long): Flow<List<Record>>
}
