package app.doggy.mybrary.core.domain.repository

import app.doggy.mybrary.core.domain.model.Memo
import app.doggy.mybrary.core.domain.model.MemoId

interface MemoRepository {
  suspend fun createMemo(memo: Memo): Boolean
  suspend fun postMemo(memoId: MemoId): Memo
}
