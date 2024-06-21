package app.kaito_dogi.mybrary.core.domain.repository

import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.MyBookId

interface MemoRepository {
  suspend fun getMemos(myBookId: MyBookId): List<Memo>

  suspend fun createMemo(draftMemo: DraftMemo): Boolean

  suspend fun editMemo(
    memoId: MemoId,
    draftMemo: DraftMemo,
  ): Boolean

  suspend fun postMemo(memoId: MemoId): Memo
}
