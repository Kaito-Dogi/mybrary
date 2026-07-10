package app.kaito_dogi.mybrary.core.repository

import app.kaito_dogi.mybrary.core.common.coroutines.AppDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.AppDispatchers
import app.kaito_dogi.mybrary.core.database.MemoDao
import app.kaito_dogi.mybrary.core.database.MemoEntity
import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.repository.MemoRepository
import app.kaito_dogi.mybrary.core.repository.convertor.toMemo
import java.util.UUID
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class DefaultMemoRepository @Inject constructor(
  private val memoDao: MemoDao,
  @param:AppDispatcher(appDispatchers = AppDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : MemoRepository {
  override suspend fun getMemoList(myBookId: MyBookId): List<Memo> = withContext(dispatcher) {
    memoDao.getByMyBookId(myBookId = myBookId.value).map(MemoEntity::toMemo)
  }

  override suspend fun createMemo(draftMemo: DraftMemo): Memo = withContext(dispatcher) {
    val entity = MemoEntity(
      id = UUID.randomUUID().toString(),
      myBookId = draftMemo.myBookId.value,
      content = draftMemo.content,
      startPage = draftMemo.pageRange?.start,
      endPage = draftMemo.pageRange?.end,
      createdAt = System.currentTimeMillis(),
      editedAt = null,
    )
    memoDao.upsert(entity = entity)
    entity.toMemo()
  }

  override suspend fun editMemo(
    memoId: MemoId,
    draftMemo: DraftMemo,
  ): Memo = withContext(dispatcher) {
    val entity = requireNotNull(value = memoDao.getById(id = memoId.value)) {
      "Memo が見つかりません: ${memoId.value}"
    }
    val newEntity = entity.copy(
      content = draftMemo.content,
      startPage = draftMemo.pageRange?.start,
      endPage = draftMemo.pageRange?.end,
      editedAt = System.currentTimeMillis(),
    )
    memoDao.upsert(entity = newEntity)
    newEntity.toMemo()
  }
}
