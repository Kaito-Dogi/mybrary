package app.kaito_dogi.mybrary.core.data

import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.repository.MemoRepository
import java.time.LocalDateTime
import javax.inject.Inject

internal class MemoRepositoryImpl @Inject constructor() : MemoRepository {
  // TODO: 実装
  override suspend fun getMemos(myBookId: MyBookId): List<Memo> {
    return emptyList()
  }

  // TODO: 実装
  override suspend fun createMemo(draftMemo: DraftMemo): Boolean {
    return true
  }

  // TODO: 実装
  override suspend fun editMemo(
    memoId: MemoId,
    draftMemo: DraftMemo,
  ): Boolean {
    return true
  }

  // TODO: 実装
  override suspend fun postMemo(memoId: MemoId): Memo {
    return Memo(
      id = MemoId(0L),
      myBookId = MyBookId(0L),
      content = "content",
      fromPage = null,
      toPage = null,
      createdAt = LocalDateTime.now(),
      isPosted = false,
      postedAt = null,
      likeCount = null,
    )
  }
}
