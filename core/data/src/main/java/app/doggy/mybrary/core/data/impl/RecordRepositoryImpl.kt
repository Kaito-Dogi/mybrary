package app.doggy.mybrary.core.data.impl

import app.doggy.mybrary.core.common.coroutines.dispatcher.Dispatcher
import app.doggy.mybrary.core.common.coroutines.dispatcher.MybraryDispatchers
import app.doggy.mybrary.core.database.dao.RecordDao
import app.doggy.mybrary.core.database.entity.toEntity
import app.doggy.mybrary.core.domain.legacy.model.book.BookId
import app.doggy.mybrary.core.domain.legacy.model.record.Record
import app.doggy.mybrary.core.domain.legacy.model.record.RecordId
import app.doggy.mybrary.core.domain.repository.legacy.RecordRepository
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

internal class RecordRepositoryImpl @Inject constructor(
  private val recordDao: RecordDao,
  @Dispatcher(MybraryDispatchers.IO)
  private val ioDispatcher: CoroutineDispatcher,
) : RecordRepository {

  override suspend fun record(
    record: Record,
    bookId: BookId,
  ) {
    withContext(ioDispatcher) {
      recordDao.upsertRecord(record = record.toEntity(bookId))
    }
  }

  override suspend fun updateRecord(
    record: Record,
    bookId: BookId,
  ) {
    withContext(ioDispatcher) {
      recordDao.upsertRecord(record = record.toEntity(bookId))
    }
  }

  override suspend fun deleteRecord(recordId: RecordId) {
    withContext(ioDispatcher) {
      recordDao.deleteRecordById(recordId = recordId.value)
    }
  }

  override fun getRecord(recordId: RecordId): Flow<Record> =
    recordDao.getRecordById(recordId = recordId.value).map { it.toRecord() }
}
