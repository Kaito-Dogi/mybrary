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
import app.kaito_dogi.mybrary.core.supabase.Table
import app.kaito_dogi.mybrary.core.supabase.from
import app.kaito_dogi.mybrary.core.supabase.model.Memo
import app.kaito_dogi.mybrary.core.supabase.model.MyBook
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MybraryAuthApiImpl @Inject constructor(
  private val supabaseClient: SupabaseClient,
) : MybraryAuthApi {
  override suspend fun postBook(request: PostBookRequest): PostBookResponse {
    val result = supabaseClient.postgrest
      .from(table = Table.Book)
      .insert(
        value = request,
        request = {
          select(
            columns = Columns.ALL,
          )
        },
      )
    return result.decodeSingle<PostBookResponse>()
  }

  override suspend fun postMemo(request: PostMemoRequest): PostMemoResponse {
    val result = supabaseClient.postgrest
      .from(table = Table.Memo)
      .insert(
        value = request,
        request = {
          select(
            // FIXME: ユーザー情報をクエリできるようにする
            columns = Columns.raw(value = "*"),
          )
        },
      )
    return result.decodeSingle<PostMemoResponse>()
  }

  override suspend fun patchMemo(
    id: String,
    request: PatchMemoRequest,
  ): PatchMemoResponse {
    val result = supabaseClient.postgrest
      .from(table = Table.Memo)
      .update(
        update = {
          Memo::content setTo request.content
        },
        request = {
          select(
            // FIXME: ユーザー情報をクエリできるようにする
            columns = Columns.raw(value = "*"),
          )
        },
      )
    return result.decodeSingle<PatchMemoResponse>()
  }

  override suspend fun deleteMemo(id: String) {
    TODO("Not yet implemented")
  }

  // FIXME: user_id をリクエストの段階で渡せるようにする
  override suspend fun postMyBook(request: PostMyBookRequest): PostMyBookResponse {
    val id = supabaseClient.auth.currentUserOrNull()?.id
    val requestContainUserId = mapOf(
      "user_id" to id,
      "book_id" to request.bookId,
    )
    val result = supabaseClient.postgrest
      .from(table = Table.MyBook)
      .insert(requestContainUserId) {
        select(
          columns = Columns.raw(
            value = "*,book(*)",
          ),
        )
      }
    return result.decodeSingle<PostMyBookResponse>()
  }

  override suspend fun patchMyBook(id: String) {
    TODO("Not yet implemented")
  }

  override suspend fun patchMyBookFavorite(
    id: String,
    request: PatchMyBookFavoriteRequest,
  ): PatchMyBookFavoriteResponse {
    val result = supabaseClient.postgrest
      .from(table = Table.MyBook)
      .update(
        update = {
          MyBook::isFavorite setTo request.isFavorite
        },
        request = {
          filter {
            MyBook::id eq id
          }
          select(
            columns = Columns.raw(
              value = "*,book(*)",
            ),
          )
        },
      )
    return result.decodeSingle<PatchMyBookFavoriteResponse>()
  }

  override suspend fun deleteMyBook(id: String) {
    TODO("Not yet implemented")
  }
}
