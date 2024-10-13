package app.kaito_dogi.mybrary.core.repository.mock

import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatchers
import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.model.PageRange
import app.kaito_dogi.mybrary.core.domain.repository.MemoRepository
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext

@Singleton
internal class MockMemoRepository @Inject constructor(
  @MybraryDispatcher(MybraryDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : MemoRepository {
  private val mockMemoList = MutableStateFlow<List<Memo>>(emptyList())

  override suspend fun getMemoList(myBookId: MyBookId): List<Memo> = withContext(dispatcher) {
    delay(1_000)

    mockMemoList.update {
      createMockMemoList(myBookId = myBookId)
    }

    return@withContext mockMemoList.value
  }

  override suspend fun createMemo(draftMemo: DraftMemo): Memo = withContext(dispatcher) {
    delay(1_000)

    val createdMemo = Memo(
      id = MemoId(value = "${mockMemoList.value.size}"),
      // user = User(
      //   id = UserId(value = "userId"),
      //   name = "ユーザー名",
      // ),
      myBookId = draftMemo.myBookId,
      content = draftMemo.content,
      pageRange = draftMemo.pageRange,
      createdAt = LocalDateTime.now(),
      editedAt = null,
      publishedAt = null,
      likeCount = 0,
    )
    mockMemoList.update { it + createdMemo }

    return@withContext createdMemo
  }

  override suspend fun editMemo(
    memoId: MemoId,
    draftMemo: DraftMemo,
  ): Memo = withContext(dispatcher) {
    delay(1_000)

    val memo = mockMemoList.value.first { it.id == memoId }
    val editedMemo = memo.copy(
      content = draftMemo.content,
      pageRange = draftMemo.pageRange,
      editedAt = LocalDateTime.now(),
    )
    val newMemoList = mockMemoList.value.map {
      if (it.id == memoId) editedMemo else it
    }
    mockMemoList.update { newMemoList }

    return@withContext editedMemo
  }

  override suspend fun publishMemo(memoId: MemoId): Memo = withContext(dispatcher) {
    delay(1_000)

    val memo = mockMemoList.value.first { it.id == memoId }
    val publishedMemo = memo.copy(
      publishedAt = LocalDateTime.now(),
    )
    val newMemoList = mockMemoList.value.map {
      if (it.id == memoId) publishedMemo else it
    }
    mockMemoList.update { newMemoList }

    return@withContext publishedMemo
  }
}

private fun createMockMemoList(myBookId: MyBookId) = List(10) { index ->
  val startPage = if (index % 2 == 0) index * 100 else null
  val endPage = if (index % 4 == 0) (index + 1) * 100 else null
  Memo(
    id = MemoId(value = "$index"),
    // user = User(
    //   id = UserId(value = "userId"),
    //   name = "ユーザー名",
    // ),
    myBookId = myBookId,
    content = "メモ$index",
    pageRange = startPage?.let {
      PageRange(
        start = it,
        end = endPage,
      )
    },
    createdAt = LocalDateTime.now(),
    editedAt = null,
    publishedAt = null,
    likeCount = 0,
  )
}
