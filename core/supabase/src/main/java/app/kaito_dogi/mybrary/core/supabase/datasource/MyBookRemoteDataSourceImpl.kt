package app.kaito_dogi.mybrary.core.supabase.datasource

import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatchers
import app.kaito_dogi.mybrary.core.data.command.PostMyBookCommand
import app.kaito_dogi.mybrary.core.data.datasource.MyBookRemoteDataSource
import app.kaito_dogi.mybrary.core.data.dto.MyBookDto
import app.kaito_dogi.mybrary.core.supabase.model.MyBookResponse
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

private const val MY_BOOK_TABLE = "my_book"
private val MY_BOOK_COLUMN_LIST = listOf("*", "book(*)")

internal class MyBookRemoteDataSourceImpl @Inject constructor(
  private val supabaseClient: SupabaseClient,
  @MybraryDispatcher(MybraryDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : MyBookRemoteDataSource {
  override suspend fun getMyBook(myBookId: String): MyBookDto = withContext(dispatcher) {
    val result = supabaseClient.postgrest
      .from(MY_BOOK_TABLE)
      .select(
        columns = Columns.list(MY_BOOK_COLUMN_LIST),
        request = {
          filter {
            MyBookResponse::myBookId eq myBookId
          }
        },
      )
    val response = result.decodeSingle<MyBookResponse>()
    return@withContext response.toDto()
  }

  override suspend fun getMyBooks(
    userId: String,
  ): List<MyBookDto> = withContext(dispatcher) {
    // FIXME: 外から渡されたユーザー ID を使用するようにする
    val tempUserId = supabaseClient.auth.currentUserOrNull()?.id ?: throw IllegalStateException("userId is null")
    val result = supabaseClient.postgrest
      .from(table = MY_BOOK_TABLE)
      .select(
        columns = Columns.list(MY_BOOK_COLUMN_LIST),
        request = {
          filter {
            MyBookResponse::userId eq tempUserId
          }
        },
      )
    val responseList = result.decodeList<MyBookResponse>()
    return@withContext responseList.map(MyBookResponse::toDto)
  }

  override suspend fun postMyBook(command: PostMyBookCommand): MyBookDto = withContext(dispatcher) {
    // FIXME: 外から渡されたユーザー ID を使用するようにする
    val tempUserId = supabaseClient.auth.currentUserOrNull()?.id ?: throw IllegalStateException("userId is null")
    val tempCommand = command.copy(userId = tempUserId)
    val result = supabaseClient.postgrest
      .from(table = MY_BOOK_TABLE)
      .insert(
        value = tempCommand,
        request = {
          select(
            columns = Columns.list(MY_BOOK_COLUMN_LIST),
          )
        },
      )
    val response = result.decodeSingle<MyBookResponse>()
    return@withContext response.toDto()
  }

  override suspend fun patchMyBookIsPinned(
    myBookId: String,
    isPinned: Boolean,
  ): MyBookDto = withContext(dispatcher) {
    val result = supabaseClient.postgrest
      .from(MY_BOOK_TABLE)
      .update(
        update = {
          MyBookResponse::isFavorite setTo isPinned
        },
        request = {
          filter {
            MyBookResponse::myBookId eq myBookId
          }
          select(
            columns = Columns.list(MY_BOOK_COLUMN_LIST),
          )
        },
      )
    val response = result.decodeSingle<MyBookResponse>()
    return@withContext response.toDto()
  }

  override suspend fun patchMyBookIsFavorite(
    myBookId: String,
    isFavorite: Boolean,
  ): MyBookDto = withContext(dispatcher) {
    val result = supabaseClient.postgrest
      .from(MY_BOOK_TABLE)
      .update(
        update = {
          MyBookResponse::isFavorite setTo isFavorite
        },
        request = {
          filter {
            MyBookResponse::myBookId eq myBookId
          }
          select(
            columns = Columns.list(MY_BOOK_COLUMN_LIST),
          )
        },
      )
    val response = result.decodeSingle<MyBookResponse>()
    return@withContext response.toDto()
  }

  override suspend fun patchMyBookIsPublic(
    myBookId: String,
    isPublic: Boolean,
  ): MyBookDto = withContext(dispatcher) {
    val result = supabaseClient.postgrest
      .from(MY_BOOK_TABLE)
      .update(
        update = {
          MyBookResponse::isFavorite setTo isPublic
        },
        request = {
          filter {
            MyBookResponse::myBookId eq myBookId
          }
          select(
            columns = Columns.list(MY_BOOK_COLUMN_LIST),
          )
        },
      )
    val response = result.decodeSingle<MyBookResponse>()
    return@withContext response.toDto()
  }

  override suspend fun patchMyBookIsArchived(
    myBookId: String,
    isArchived: Boolean,
  ): MyBookDto = withContext(dispatcher) {
    val result = supabaseClient.postgrest
      .from(MY_BOOK_TABLE)
      .update(
        update = {
          MyBookResponse::isFavorite setTo isArchived
        },
        request = {
          filter {
            MyBookResponse::myBookId eq myBookId
          }
          select(
            columns = Columns.list(MY_BOOK_COLUMN_LIST),
          )
        },
      )
    val response = result.decodeSingle<MyBookResponse>()
    return@withContext response.toDto()
  }

  override suspend fun deleteMyBook(myBookId: String) = withContext(dispatcher) {
    supabaseClient.postgrest
      .from(MY_BOOK_TABLE)
      .delete(
        request = {
          filter {
            MyBookResponse::myBookId eq myBookId
          }
        },
      )
    return@withContext
  }
}
