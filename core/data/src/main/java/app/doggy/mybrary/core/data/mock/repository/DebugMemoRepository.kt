package app.doggy.mybrary.core.data.repository

import app.doggy.mybrary.core.data.model.dummyMemos
import app.doggy.mybrary.core.domain.model.Memo
import app.doggy.mybrary.core.domain.model.MemoId
import app.doggy.mybrary.core.domain.repository.MemoRepository
import java.util.Date
import javax.inject.Inject

internal class DebugMemoRepository @Inject constructor() : MemoRepository {
  override suspend fun createMemo(memo: Memo): Boolean {
    return true
  }

  override suspend fun postMemo(memoId: MemoId): Memo {
    return dummyMemos
      .first { it.id == memoId }
      .copy(
        isPosted = false,
        postedAt = Date(),
        likeCount = 0,
      )
  }
}
