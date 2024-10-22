package app.kaito_dogi.mybrary.core.supabase.datasource

import app.kaito_dogi.mybrary.core.common.coroutines.AppDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.AppDispatchers
import app.kaito_dogi.mybrary.core.data.datasource.AuthRemoteDataSource
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.OtpType
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.OTP
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class DefaultAuthRemoteDataSource @Inject constructor(
  private val supabaseClient: SupabaseClient,
  @AppDispatcher(AppDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : AuthRemoteDataSource {
  override suspend fun otpSignIn(
    email: String,
    captchaToken: String,
  ) = withContext(dispatcher) {
    supabaseClient.auth.signInWith(
      provider = OTP,
      config = {
        this.email = email
        this.captchaToken = captchaToken
      },
    )
  }

  override suspend fun otpSignUp(
    email: String,
    captchaToken: String,
  ): Unit = withContext(dispatcher) {
    supabaseClient.auth.signUpWith(
      provider = OTP,
      config = {
        this.email = email
        this.captchaToken = captchaToken
      },
    )
  }

  override suspend fun verifyOtp(
    email: String,
    otp: String,
    captchaToken: String,
  ) = withContext(dispatcher) {
    supabaseClient.auth.verifyEmailOtp(
      type = OtpType.Email.EMAIL,
      email = email,
      token = otp,
      captchaToken = captchaToken,
    )
  }

  override suspend fun googleSignIn() = withContext(dispatcher) {
    TODO("Not yet implemented")
  }

  override suspend fun googleSignUp() = withContext(dispatcher) {
    TODO("Not yet implemented")
  }

  override suspend fun anonymousSignIn(captchaToken: String) = withContext(dispatcher) {
    supabaseClient.auth.signInAnonymously(captchaToken = captchaToken)
  }

  override suspend fun logout() = withContext(dispatcher) {
    supabaseClient.auth.signOut()
  }

  override suspend fun hasCurrentSession(): Boolean = withContext(dispatcher) {
    val currentSession = supabaseClient.auth.currentSessionOrNull()
    return@withContext currentSession != null
  }
}
