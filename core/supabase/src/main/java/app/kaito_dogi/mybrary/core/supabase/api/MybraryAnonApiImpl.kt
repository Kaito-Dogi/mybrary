package app.kaito_dogi.mybrary.core.supabase.api

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAnonApi
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostSendOtpRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostVerifyOtpRequest
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetBookByIsbnResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMemosResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMyBookResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.GetMyBooksResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.BookResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MemoResponse
import app.kaito_dogi.mybrary.core.api.mybrary.response.model.MyBookResponse
import app.kaito_dogi.mybrary.core.supabase.ext.select
import app.kaito_dogi.mybrary.core.supabase.table.Table
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.OtpType
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.OTP
import io.github.jan.supabase.postgrest.postgrest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MybraryAnonApiImpl @Inject constructor(
  private val supabaseClient: SupabaseClient,
) : MybraryAnonApi {
  override suspend fun getBookByIsbn(isbn: String): GetBookByIsbnResponse {
    val result = supabaseClient.postgrest.select(
      table = Table.Book,
      request = {
        filter {
          BookResponse::isbn eq isbn
        }
      },
    )
    return try {
      result.decodeSingle<BookResponse>()
    } catch (e: NoSuchElementException) {
      null
    }
  }

  override suspend fun getMemos(myBookId: String): GetMemosResponse {
    val result = supabaseClient.postgrest.select(
      table = Table.Memo,
      request = {
        filter {
          MemoResponse::myBookId eq myBookId
        }
      },
    )
    return result.decodeList<MemoResponse>()
  }

  override suspend fun getMyBook(myBookId: String): GetMyBookResponse {
    val result = supabaseClient.postgrest.select(
      table = Table.MyBook,
      request = {
        filter {
          MyBookResponse::id eq myBookId
        }
      },
    )
    return result.decodeSingle<MyBookResponse>()
  }

  override suspend fun getMyBooks(): GetMyBooksResponse {
    val result = supabaseClient.postgrest.select(table = Table.MyBook)
    return result.decodeList<MyBookResponse>()
  }

  override suspend fun getUser() {
    TODO("Not yet implemented")
  }

  override suspend fun postSendOtp(request: PostSendOtpRequest) {
    supabaseClient.auth.signInWith(OTP) {
      email = request.email
    }
  }

  override suspend fun postVerifyOtp(request: PostVerifyOtpRequest) {
    supabaseClient.auth.verifyEmailOtp(
      type = OtpType.Email.EMAIL,
      email = request.email,
      token = request.otp,
    )
  }

  override suspend fun logout() {
    supabaseClient.auth.signOut()
  }

  override suspend fun getSession(): Boolean {
    return supabaseClient.auth.currentSessionOrNull()?.let { true } ?: false
  }
}
