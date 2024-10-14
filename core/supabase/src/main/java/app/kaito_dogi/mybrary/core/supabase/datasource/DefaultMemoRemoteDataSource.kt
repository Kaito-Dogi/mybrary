package app.kaito_dogi.mybrary.core.supabase.datasource

import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatchers
import app.kaito_dogi.mybrary.core.data.command.PatchMemoCommand
import app.kaito_dogi.mybrary.core.data.command.PostMemoCommand
import app.kaito_dogi.mybrary.core.data.datasource.MemoRemoteDataSource
import app.kaito_dogi.mybrary.core.data.dto.MemoDto
import app.kaito_dogi.mybrary.core.supabase.input.toMemoInput
import app.kaito_dogi.mybrary.core.supabase.response.MemoResponse
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

private const val MEMO_TABLE = "memo"

// FIXME: ユーザー情報のクエリを追加する
private val MEMO_COLUMN_LIST = listOf("*")

internal class DefaultMemoRemoteDataSource @Inject constructor(
  private val supabaseClient: SupabaseClient,
  @MybraryDispatcher(MybraryDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : MemoRemoteDataSource {
  // FIXME: ユーザー情報をクエリできるようにする
  override suspend fun getMemos(myBookId: String): List<MemoDto> = withContext(dispatcher) {
    val result = supabaseClient.postgrest
      .from(MEMO_TABLE)
      .select(
        columns = Columns.list(MEMO_COLUMN_LIST),
        request = {
          filter {
            MemoResponse::myBookId eq myBookId
          }
        },
      )
    val memoResponseList = result.decodeList<MemoResponse>()
    return@withContext memoResponseList.map(MemoResponse::toMemoDto)
  }

  // FIXME: ユーザー情報をクエリできるようにする
  override suspend fun postMemo(postMemoCommand: PostMemoCommand): MemoDto = withContext(dispatcher) {
    val memoInput = postMemoCommand.toMemoInput()
    val result = supabaseClient.postgrest
      .from(MEMO_TABLE)
      .insert(
        value = memoInput,
        request = {
          select(columns = Columns.list(MEMO_COLUMN_LIST))
        },
      )
    val memoResponse = result.decodeSingle<MemoResponse>()
    return@withContext memoResponse.toMemoDto()
  }

  // FIXME: ユーザー情報をクエリできるようにする
  override suspend fun patchMemo(patchMemoCommand: PatchMemoCommand): MemoDto = withContext(dispatcher) {
    val result = supabaseClient.postgrest
      .from(MEMO_TABLE)
      .update(
        update = {
          MemoResponse::content setTo patchMemoCommand.content
          MemoResponse::startPage setTo patchMemoCommand.startPage
          MemoResponse::endPage setTo patchMemoCommand.endPage
        },
        request = {
          filter {
            MemoResponse::id eq patchMemoCommand.memoId
          }
          select(columns = Columns.list(MEMO_COLUMN_LIST))
        },
      )
    val memoResponse = result.decodeSingle<MemoResponse>()
    return@withContext memoResponse.toMemoDto()
  }

  override suspend fun deleteMemo(memoId: String) = withContext(dispatcher) {
    supabaseClient.postgrest
      .from(MEMO_TABLE)
      .delete(
        request = {
          filter {
            MemoResponse::id eq memoId
          }
        },
      )
    return@withContext
  }
}
