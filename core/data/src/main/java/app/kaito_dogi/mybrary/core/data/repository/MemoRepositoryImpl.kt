package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAnonApi
import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAuthApi
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostMemoRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PutMemoRequest
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MemoResponse
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.Dispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatchers
import app.kaito_dogi.mybrary.core.data.convertor.toMemo
import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.repository.MemoRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

@Singleton
internal class MemoRepositoryImpl @Inject constructor(
  private val mybraryAnonApi: MybraryAnonApi,
  private val mybraryAuthApi: MybraryAuthApi,
  @Dispatcher(MybraryDispatchers.IO) private val dispatcher: CoroutineDispatcher,
) : MemoRepository {
  override suspend fun getMemoList(myBookId: MyBookId): List<Memo> = withContext(dispatcher) {
    val response = mybraryAnonApi.getMemos(myBookId = myBookId.value)
    return@withContext response.map(MemoResponse::toMemo)
  }

  override suspend fun createMemo(draftMemo: DraftMemo): Memo = withContext(dispatcher) {
    val response = mybraryAuthApi.postMemo(
      request = PostMemoRequest(
        myBookId = draftMemo.myBookId.value,
        content = draftMemo.content,
        startPage = draftMemo.pageRange?.start,
        endPage = draftMemo.pageRange?.end,
      ),
    )
    return@withContext response.toMemo()
  }

  override suspend fun editMemo(
    memoId: MemoId,
    draftMemo: DraftMemo,
  ): Memo = withContext(dispatcher) {
    val response = mybraryAuthApi.putMemo(
      id = memoId.value,
      request = PutMemoRequest(
        content = draftMemo.content,
        startPage = draftMemo.pageRange?.start,
        endPage = draftMemo.pageRange?.end,
      ),
    )
    return@withContext response.toMemo()
  }

  override suspend fun publishMemo(memoId: MemoId): Memo {
    TODO("Not yet implemented")
  }
}
