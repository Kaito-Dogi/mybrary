package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.data.convertor.toDraftMemo
import app.kaito_dogi.mybrary.core.data.convertor.toEntity
import app.kaito_dogi.mybrary.core.database.local.DraftMemoDao
import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.repository.DraftMemoRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class DraftMemoRepositoryImpl @Inject constructor(
  private val draftMemoDao: DraftMemoDao,
) : DraftMemoRepository {
  override suspend fun createDraftMemo(draftMemo: DraftMemo) {
    draftMemoDao.insert(entity = draftMemo.toEntity())
  }

  override suspend fun updateDraftMemo(draftMemo: DraftMemo) {
    draftMemoDao.update(entity = draftMemo.toEntity())
  }

  override suspend fun deleteDraftMemo(draftMemo: DraftMemo) {
    draftMemoDao.delete(entity = draftMemo.toEntity())
  }

  override suspend fun getDraftMemo(myBookId: MyBookId): DraftMemo {
    return draftMemoDao.getByMyBookId(myBookId = myBookId.value).toDraftMemo()
  }
}
