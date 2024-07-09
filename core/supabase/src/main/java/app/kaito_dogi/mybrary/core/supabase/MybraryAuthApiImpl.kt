package app.kaito_dogi.mybrary.core.supabase

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAuthApi
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMemos
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMyBookResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMyBooksResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MemoResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MyBookResponse
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MybraryAuthApiImpl @Inject constructor(
  private val supabaseClient: SupabaseClient,
) : MybraryAuthApi {
  override suspend fun getMyBooks(): GetMyBooksResponse {
    return supabaseClient.postgrest.from(table = "my_books").select(
      columns = Columns.raw(
        value = "*,users:user_id(*),books:book_id(*,authors(*))",
      ),
    ).decodeList<MyBookResponse>()
  }

  override suspend fun getMyBook(myBookId: Long): GetMyBookResponse {
    return supabaseClient.postgrest.from(table = "my_books").select(
      columns = Columns.raw(
        value = "*,users:user_id(*),books:book_id(*,authors(*))",
      ),
      request = {
        filter {
          MyBookResponse::id eq myBookId
        }
      },
    ).decodeSingle<MyBookResponse>()
  }

  override suspend fun postMyBooks() {
    TODO("Not yet implemented")
  }

  override suspend fun putMyBooks() {
    TODO("Not yet implemented")
  }

  override suspend fun getMemos(myBookId: Long): GetMemos {
    return supabaseClient.postgrest.from(table = "memos").select(
      columns = Columns.raw(
        value = "*,my_books(users:user_id(*))",
      ),
      request = {
        filter {
          MemoResponse::myBookId eq myBookId
        }
      },
    ).decodeList<MemoResponse>()
  }

  override suspend fun postMemos() {
    TODO("Not yet implemented")
  }

  override suspend fun putMemos() {
    TODO("Not yet implemented")
  }

  override suspend fun getUser() {
    TODO("Not yet implemented")
  }
}
