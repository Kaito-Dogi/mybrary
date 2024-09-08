package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatchers
import app.kaito_dogi.mybrary.core.data.convertor.toDraftMemo
import app.kaito_dogi.mybrary.core.data.convertor.toEntity
import app.kaito_dogi.mybrary.core.database.DraftMemoDao
import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.repository.DraftMemoRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

@Singleton
internal class DraftMemoRepositoryImpl @Inject constructor(
  private val draftMemoDao: DraftMemoDao,
  @MybraryDispatcher(MybraryDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : DraftMemoRepository {
  override suspend fun saveDraftMemo(draftMemo: DraftMemo) = withContext(dispatcher) {
    draftMemoDao.upsert(entity = draftMemo.toEntity())
  }

  override suspend fun deleteDraftMemo(myBookId: MyBookId) = withContext(dispatcher) {
    draftMemoDao.deleteByMyBookId(myBookId = myBookId.value)
  }

  override suspend fun getDraftMemo(myBookId: MyBookId): DraftMemo? = withContext(dispatcher) {
    draftMemoDao.getByMyBookId(myBookId = myBookId.value)?.toDraftMemo()
  }
}
