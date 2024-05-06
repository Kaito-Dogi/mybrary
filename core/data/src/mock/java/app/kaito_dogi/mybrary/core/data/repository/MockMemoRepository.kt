package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.data.model.dummyMemos
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.repository.MemoRepository
import java.time.LocalDateTime
import javax.inject.Inject

internal class MockMemoRepository @Inject constructor() : MemoRepository {
  override suspend fun createMemo(memo: Memo): Boolean {
    return true
  }

  override suspend fun postMemo(memoId: MemoId): Memo {
    return dummyMemos
      .first { it.id == memoId }
      .copy(
        isPosted = false,
        postedAt = LocalDateTime.now(),
        likeCount = 0,
      )
  }
}
