package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.repository.MemoRepository
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

@Singleton
internal class MockMemoRepository @Inject constructor() : MemoRepository {
  private val mockMemoList = MutableStateFlow<List<Memo>>(emptyList())

  override suspend fun getMemoList(myBookId: MyBookId): List<Memo> {
    delay(1_000)

    mockMemoList.update {
      createMockMemoList(myBookId = myBookId)
    }

    return mockMemoList.value
  }

  override suspend fun createMemo(draftMemo: DraftMemo): Memo {
    delay(1_000)

    val createdMemo = Memo(
      id = MemoId(mockMemoList.value.size.toLong()),
      myBookId = draftMemo.myBookId,
      content = draftMemo.content,
      fromPage = draftMemo.fromPage,
      toPage = draftMemo.toPage,
      createdAt = LocalDateTime.now(),
      editedAt = null,
      isPosted = false,
      postedAt = null,
      likeCount = null,
    )
    mockMemoList.update { it + createdMemo }

    return createdMemo
  }

  override suspend fun editMemo(
    memoId: MemoId,
    draftMemo: DraftMemo,
  ): Memo {
    delay(1_000)

    val memo = mockMemoList.value.first { it.id == memoId }
    val editedMemo = memo.copy(
      content = draftMemo.content,
      fromPage = draftMemo.fromPage,
      toPage = draftMemo.toPage,
      editedAt = LocalDateTime.now(),
    )
    val newMemoList = mockMemoList.value.map {
      if (it.id == memoId) editedMemo else it
    }
    mockMemoList.update { newMemoList }

    return editedMemo
  }

  override suspend fun postMemo(memoId: MemoId): Memo {
    delay(1_000)

    val memo = mockMemoList.value.first { it.id == memoId }
    val postedMemo = memo.copy(
      isPosted = true,
      postedAt = LocalDateTime.now(),
    )
    val newMemoList = mockMemoList.value.map {
      if (it.id == memoId) postedMemo else it
    }
    mockMemoList.update { newMemoList }

    return postedMemo
  }
}

private fun createMockMemoList(myBookId: MyBookId) = List(10) {
  val fromPage = if (it % 2 == 0) it * 100 else null
  val toPage = if (it % 4 == 0) (it + 1) * 100 else null
  Memo(
    id = MemoId(it.toLong()),
    myBookId = myBookId,
    content = "メモ$it",
    fromPage = fromPage,
    toPage = toPage,
    createdAt = LocalDateTime.now(),
    editedAt = null,
    isPosted = false,
    postedAt = null,
    likeCount = null,
  )
}
