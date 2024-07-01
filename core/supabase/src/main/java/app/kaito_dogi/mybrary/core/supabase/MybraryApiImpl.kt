package app.kaito_dogi.mybrary.core.supabase

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryApi
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMyBookResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMyBooksResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MyBookResponse
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MybraryApiImpl @Inject constructor(
  private val supabaseClient: SupabaseClient,
) : MybraryApi {
  override suspend fun getMyBooks(): GetMyBooksResponse {
    return supabaseClient.postgrest
      .from(table = "my_books")
      .select(
        columns = Columns.raw(
          value = """
            *,
            users:user_id(*),
            books:book_id(*, authors(*))
          """.trimIndent(),
        ),
      )
      .decodeList<MyBookResponse>()
  }

  override suspend fun getMyBook(myBookId: Long): GetMyBookResponse {
    TODO("Not yet implemented")
  }

  override suspend fun postMyBooks() {
    TODO("Not yet implemented")
  }

  override suspend fun putMyBooks() {
    TODO("Not yet implemented")
  }

  override suspend fun getMemos() {
    TODO("Not yet implemented")
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
