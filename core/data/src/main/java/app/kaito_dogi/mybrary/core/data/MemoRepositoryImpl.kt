package app.kaito_dogi.mybrary.core.data

import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.repository.MemoRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MemoRepositoryImpl @Inject constructor() : MemoRepository {
  override suspend fun getMemos(myBookId: MyBookId): List<Memo> {
    TODO("Not yet implemented")
  }

  override suspend fun createMemo(draftMemo: DraftMemo): Memo {
    TODO("Not yet implemented")
  }

  override suspend fun editMemo(memoId: MemoId, draftMemo: DraftMemo): Memo {
    TODO("Not yet implemented")
  }

  override suspend fun postMemo(memoId: MemoId): Memo {
    TODO("Not yet implemented")
  }
}
