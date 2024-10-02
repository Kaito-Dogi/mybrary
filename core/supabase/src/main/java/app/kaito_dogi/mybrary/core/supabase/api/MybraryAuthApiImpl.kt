package app.kaito_dogi.mybrary.core.supabase.api

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAuthApi
import app.kaito_dogi.mybrary.core.api.mybrary.request.PatchMemoRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PatchMyBookFavoriteRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostBookRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostMemoRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostMyBookRequest
import app.kaito_dogi.mybrary.core.api.mybrary.response.PatchMemoResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.PatchMyBookFavoriteResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.PostBookResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.PostMemoResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.PostMyBookResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MemoResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MyBookResponse
import app.kaito_dogi.mybrary.core.supabase.ext.insert
import app.kaito_dogi.mybrary.core.supabase.ext.update
import app.kaito_dogi.mybrary.core.supabase.table.Table
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MybraryAuthApiImpl @Inject constructor(
  private val supabaseClient: SupabaseClient,
) : MybraryAuthApi {
  override suspend fun postBook(request: PostBookRequest): PostBookResponse {
    val result = supabaseClient.postgrest.insert(
      table = Table.Book,
      value = request,
    )
    return result.decodeSingle<PostBookResponse>()
  }

  override suspend fun postMemo(request: PostMemoRequest): PostMemoResponse {
    val result = supabaseClient.postgrest.insert(
      table = Table.Memo,
      value = request,
    )
    return result.decodeSingle<PostMemoResponse>()
  }

  override suspend fun patchMemo(
    id: String,
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

  override suspend fun deleteMemo(id: String) {
    TODO("Not yet implemented")
  }

  override suspend fun postMyBook(request: PostMyBookRequest): PostMyBookResponse {
    val result = supabaseClient.postgrest.insert(
      table = Table.MyBook,
      value = request,
    )
    return result.decodeSingle<PostMyBookResponse>()
  }

  override suspend fun patchMyBook(id: String) {
    TODO("Not yet implemented")
  }

  override suspend fun patchMyBookFavorite(
    id: String,
    request: PatchMyBookFavoriteRequest,
  ): PatchMyBookFavoriteResponse {
    val result = supabaseClient.postgrest.update(
      table = Table.MyBook,
      update = {
        MyBookResponse::isFavorite setTo request.isFavorite
      },
      filter = {
        MyBookResponse::id eq id
      },
    )
    return result.decodeSingle<PatchMyBookFavoriteResponse>()
  }

  override suspend fun deleteMyBook(id: String) {
    TODO("Not yet implemented")
  }
}
