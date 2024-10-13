package app.kaito_dogi.mybrary.core.supabase.datasource

import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatchers
import app.kaito_dogi.mybrary.core.data.command.PostBookCommand
import app.kaito_dogi.mybrary.core.data.datasource.BookRemoteDataSource
import app.kaito_dogi.mybrary.core.data.dto.BookDto
import app.kaito_dogi.mybrary.core.supabase.model.BookResponse
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

private const val BOOK_TABLE = "book"

internal class BookRemoteDataSourceImpl @Inject constructor(
  private val supabaseClient: SupabaseClient,
  @MybraryDispatcher(MybraryDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : BookRemoteDataSource {
  override suspend fun getBookByIsbn(isbn: String): BookDto = withContext(dispatcher) {
    val result = supabaseClient.postgrest
      .from(BOOK_TABLE)
      .select(
        columns = Columns.ALL,
        request = {
          filter {
            BookResponse::isbn eq isbn
          }
        },
      )
    val response = result.decodeSingle<BookResponse>()
    return@withContext response.toDto()
  }

  override suspend fun postBook(command: PostBookCommand): BookDto = withContext(dispatcher) {
    val result = supabaseClient.postgrest
      .from(BOOK_TABLE)
      .insert(
        value = command,
        request = {
          select(columns = Columns.ALL)
        },
      )
    val response = result.decodeSingle<BookResponse>()
    return@withContext response.toDto()
  }
}
