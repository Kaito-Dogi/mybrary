package app.kaito_dogi.mybrary.core.supabase.api

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAuthApi
import app.kaito_dogi.mybrary.core.api.mybrary.request.PatchMemoRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PatchMyBookFavoriteRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostMemoRequest
import app.kaito_dogi.mybrary.core.api.mybrary.response.PatchMemoResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.PatchMyBookFavoriteResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.PostMemoResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MemoResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MyBookResponse
import app.kaito_dogi.mybrary.core.supabase.ext.insert
import app.kaito_dogi.mybrary.core.supabase.ext.rpc
import app.kaito_dogi.mybrary.core.supabase.ext.update
import app.kaito_dogi.mybrary.core.supabase.rpc.Rpc
import app.kaito_dogi.mybrary.core.supabase.rpc.RpcParameters
import app.kaito_dogi.mybrary.core.supabase.table.Table
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

  override suspend fun patchMyBookFavorite(id: Long): PatchMyBookFavoriteResponse {
    val result = supabaseClient.postgrest.rpc(
      rpc = Rpc.ToggleMyBookIsFavorite,
      parameters = RpcParameters.ToggleMyBookIsFavorite(
        id = id,
      ),
      filter = {
        MyBookResponse::id eq id
      },
    )
    return result.decodeSingle<PatchMyBookFavoriteResponse>()
  }

  override suspend fun deleteMyBook(id: Long) {
    TODO("Not yet implemented")
  }

  override suspend fun postMemo(request: PostMemoRequest): PostMemoResponse {
    val result = supabaseClient.postgrest.insert(
      table = Table.Memo,
      value = request,
    )
    return result.decodeSingle<PostMemoResponse>()
  }

  override suspend fun patchMemo(
    id: Long,
    request: PatchMemoRequest,
  ): PatchMemoResponse {
    val result = supabaseClient.postgrest.update(
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
    return result.decodeSingle<PatchMemoResponse>()
  }

  override suspend fun deleteMemo(id: Long) {
    TODO("Not yet implemented")
  }
}
