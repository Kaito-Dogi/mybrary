package app.doggy.mybrary.core.data

import app.doggy.mybrary.core.domain.model.record.Record
import app.doggy.mybrary.core.domain.model.record.RecordId
import app.doggy.mybrary.core.domain.repository.RecordRepository
import kotlinx.coroutines.flow.Flow

class RecordRepositoryImpl : RecordRepository {
  override suspend fun record(record: Record) {
    TODO("Not yet implemented")
  }

  override suspend fun updateRecord(record: Record) {
    TODO("Not yet implemented")
  }

  override suspend fun deleteRecord(recordId: RecordId) {
    TODO("Not yet implemented")
  }

  override fun getRecord(recordId: RecordId): Flow<Record> {
    TODO("Not yet implemented")
  }
}
