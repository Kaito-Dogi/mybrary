package app.doggy.mybrary.core.domain.repository

import app.doggy.mybrary.core.domain.model.record.Record
import app.doggy.mybrary.core.domain.model.record.RecordId
import kotlinx.coroutines.flow.Flow

interface RecordRepository {

  suspend fun record(record: Record)

  suspend fun updateRecord(record: Record)

  suspend fun deleteRecord(recordId: RecordId)

  fun getRecord(recordId: RecordId): Flow<Record>
}
