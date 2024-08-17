package app.kaito_dogi.mybrary.core.supabase

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAuthApi
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostMemoRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PutMemoRequest
import app.kaito_dogi.mybrary.core.api.mybrary.response.PostMemoResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.PutMemoResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MemoResponse
import app.kaito_dogi.mybrary.core.supabase.ext.insert
import app.kaito_dogi.mybrary.core.supabase.ext.update
import app.kaito_dogi.mybrary.core.supabase.model.Table
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MybraryAuthApiImpl @Inject constructor(
  private val supabaseClient: SupabaseClient,
) : MybraryAuthApi {
  override suspend fun postMyBook() {
    TODO("Not yet implemented")
  }

  override suspend fun putMyBook(id: Long) {
    TODO("Not yet implemented")
  }

  override suspend fun deleteMyBook(id: Long) {
    TODO("Not yet implemented")
  }

  override suspend fun postMemo(request: PostMemoRequest): PostMemoResponse {
    val result = supabaseClient.postgrest
      .insert(
        table = Table.Memo,
        value = request,
      )
    return result.decodeSingle<PostMemoResponse>()
  }

  override suspend fun putMemo(
    id: Long,
    request: PutMemoRequest,
  ): PutMemoResponse {
    val result = supabaseClient.postgrest
      .update(
        table = Table.Memo,
        update = {
          MemoResponse::content setTo request.content
          MemoResponse::startPage setTo request.startPage
          MemoResponse::endPage setTo request.endPage
        },
        filter = {
          MemoResponse::id eq id
        },
      )
    return result.decodeSingle<PutMemoResponse>()
  }

  override suspend fun deleteMemo(id: Long) {
    TODO("Not yet implemented")
  }
}
