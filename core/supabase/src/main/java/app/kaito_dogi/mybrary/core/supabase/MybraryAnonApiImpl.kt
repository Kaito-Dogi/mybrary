package app.kaito_dogi.mybrary.core.supabase

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAnonApi
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostEmailLoginRequest
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class MybraryAnonApiImpl @Inject constructor(
  private val supabaseClient: SupabaseClient,
) : MybraryAnonApi {
  override suspend fun postEmailLogin(request: PostEmailLoginRequest) {
    supabaseClient.auth.signInWith(Email) {
      email = request.email
      password = request.password
    }
  }
}
