package app.doggy.mybrary.core.data

import app.doggy.mybrary.core.domain.model.Memo
import app.doggy.mybrary.core.domain.model.MemoId
import app.doggy.mybrary.core.domain.model.MyBookId
import app.doggy.mybrary.core.domain.repository.MemoRepository
import java.util.Date
import javax.inject.Inject

internal class MemoRepositoryImpl @Inject constructor() : MemoRepository {
  // TODO: 実装
  override suspend fun createMemo(memo: Memo): Boolean {
    return true
  }

  // TODO: 実装
  override suspend fun postMemo(memoId: MemoId): Memo {
    return Memo(
      id = MemoId(0L),
      myBookId = MyBookId(0L),
      content = "Memo",
      fromPage = null,
      toPage = null,
      createdAt = Date(),
      isPosted = false,
      postedAt = null,
      likeCount = null,
    )
  }
}
