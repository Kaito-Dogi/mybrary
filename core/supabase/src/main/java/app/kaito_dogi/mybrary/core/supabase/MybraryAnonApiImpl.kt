package app.kaito_dogi.mybrary.core.supabase

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAnonApi
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostSendOneTimePasswordRequest
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMemos
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMyBookResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMyBooksResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MemoResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MyBookResponse
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.OTP
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MybraryAnonApiImpl @Inject constructor(
  private val supabaseClient: SupabaseClient,
) : MybraryAnonApi {
  override suspend fun postSendOneTimePassword(request: PostSendOneTimePasswordRequest) {
    supabaseClient.auth.signInWith(OTP) {
      email = request.email
    }
  }

  override suspend fun getMyBooks(): GetMyBooksResponse {
    return supabaseClient.postgrest.from(table = "my_book").select(
      columns = Columns.raw(
        value = "*,profile:user_id(*),book:book_id(*,author(*))",
      ),
    ).decodeList<MyBookResponse>()
  }

  override suspend fun getMyBook(myBookId: Long): GetMyBookResponse {
    return supabaseClient.postgrest.from(table = "my_book").select(
      columns = Columns.raw(
        value = "*,profile:user_id(*),book:book_id(*,author(*))",
      ),
      request = {
        filter {
          MyBookResponse::id eq myBookId
        }
      },
    ).decodeSingle<MyBookResponse>()
  }

  override suspend fun getMemos(myBookId: Long): GetMemos {
    return supabaseClient.postgrest.from(table = "memo").select(
      columns = Columns.raw(
        value = "*,my_book(profile:user_id(*))",
      ),
      request = {
        filter {
          MemoResponse::myBookId eq myBookId
        }
      },
    ).decodeList<MemoResponse>()
  }

  override suspend fun getUser() {
    TODO("Not yet implemented")
  }
}
