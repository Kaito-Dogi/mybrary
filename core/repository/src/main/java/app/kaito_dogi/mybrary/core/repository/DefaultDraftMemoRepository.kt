package app.kaito_dogi.mybrary.core.repository

import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatchers
import app.kaito_dogi.mybrary.core.database.DraftMemoDao
import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.repository.DraftMemoRepository
import app.kaito_dogi.mybrary.core.repository.convertor.toDraftMemo
import app.kaito_dogi.mybrary.core.repository.convertor.toEntity
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

// FIXME: CoroutineDispatcher の注入をやめる
internal class DefaultDraftMemoRepository @Inject constructor(
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
