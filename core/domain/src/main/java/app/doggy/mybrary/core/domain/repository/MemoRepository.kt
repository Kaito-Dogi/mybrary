package app.doggy.mybrary.core.domain.repository

import app.doggy.mybrary.core.domain.model.Memo
import app.doggy.mybrary.core.domain.model.MemoId
import kotlinx.coroutines.flow.Flow

interface MemoRepository {
  suspend fun createMemo(memo: Memo)
  suspend fun postMemo(memoId: MemoId)
  val draftMemos: Flow<List<Memo>>
}
