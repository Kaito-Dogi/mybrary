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
import app.kaito_dogi.mybrary.core.supabase.Table
import app.kaito_dogi.mybrary.core.supabase.from
import app.kaito_dogi.mybrary.core.supabase.model.Book
import app.kaito_dogi.mybrary.core.supabase.model.Memo
import app.kaito_dogi.mybrary.core.supabase.model.MyBook
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.OtpType
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.OTP
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import javax.inject.Inject
import javax.inject.Singleton

// FIXME: 投げる例外をカスタマイズする
@Singleton
internal class MybraryAnonApiImpl @Inject constructor(
  private val supabaseClient: SupabaseClient,
) : MybraryAnonApi {
  override suspend fun anonymousLogin(hCaptchaToken: String) {
    supabaseClient.auth.signInAnonymously(captchaToken = hCaptchaToken)
  }

  override suspend fun anonymousSignUp(hCaptchaToken: String) {
    supabaseClient.auth.signInAnonymously(captchaToken = hCaptchaToken)
  }

  override suspend fun getBookByIsbn(isbn: String): GetBookByIsbnResponse {
    val result = supabaseClient.postgrest
      .from(table = Table.Book)
      .select(
        columns = Columns.ALL,
        request = {
          filter {
            Book::isbn eq isbn
          }
        },
      )
    return result.decodeList<BookResponse>().firstOrNull()
  }

  override suspend fun getMemos(myBookId: String): GetMemosResponse {
    // FIXME: ユーザー情報をクエリできるようにする
    val result = supabaseClient.postgrest
      .from(table = Table.Memo)
      .select(
        columns = Columns.raw(value = "*"),
        request = {
          filter {
            Memo::myBookId eq myBookId
          }
        },
      )
    println("あああ: ${result.data}")
    return result.decodeList<MemoResponse>()
  }

  override suspend fun getMyBook(myBookId: String): GetMyBookResponse {
    val result = supabaseClient.postgrest
      .from(table = Table.MyBook)
      .select(
        columns = Columns.raw(value = "*,book(*)"),
        request = {
          filter {
            MyBook::id eq myBookId
          }
        },
      )
    return result.decodeSingle<MyBookResponse>()
  }

  override suspend fun getMyBooks(): GetMyBooksResponse {
    val userId = supabaseClient.auth.currentUserOrNull()?.id ?: throw IllegalStateException("userId is null")
    val result = supabaseClient.postgrest
      .from(table = Table.MyBook)
      .select(
        columns = Columns.raw(value = "*,book(*)"),
        request = {
          filter {
            MyBook::userId eq userId
          }
        },
      )
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
