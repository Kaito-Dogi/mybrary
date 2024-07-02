package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryApi
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MemoResponse
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.Dispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatcher
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
  private val mybraryApi: MybraryApi,
  @Dispatcher(MybraryDispatcher.IO) private val dispatcher: CoroutineDispatcher,
) : MemoRepository {
  override suspend fun getMemoList(myBookId: MyBookId): List<Memo> = withContext(dispatcher) {
    mybraryApi.getMemos(myBookId = myBookId.value).map(MemoResponse::toMemo)
  }

  override suspend fun createMemo(draftMemo: DraftMemo): Memo {
    TODO("Not yet implemented")
  }

  override suspend fun updateMemo(memoId: MemoId, draftMemo: DraftMemo): Memo {
    TODO("Not yet implemented")
  }

  override suspend fun publishMemo(memoId: MemoId): Memo {
    TODO("Not yet implemented")
  }
}
