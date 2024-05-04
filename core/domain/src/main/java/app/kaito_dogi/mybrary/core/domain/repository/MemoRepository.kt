package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId

interface MemoRepository {
  suspend fun createMemo(memo: Memo): Boolean
  suspend fun postMemo(memoId: MemoId): Memo
}
