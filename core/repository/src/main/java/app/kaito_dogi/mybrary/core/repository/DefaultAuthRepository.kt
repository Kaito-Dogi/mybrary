package app.kaito_dogi.mybrary.core.repository

import app.kaito_dogi.mybrary.core.common.model.CaptchaToken
import app.kaito_dogi.mybrary.core.data.datasource.AuthRemoteDataSource
import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import javax.inject.Inject

internal class DefaultAuthRepository @Inject constructor(
  private val authRemoteDataSource: AuthRemoteDataSource,
) : AuthRepository {
  override suspend fun otpSignIn(
    email: String,
    captchaToken: CaptchaToken,
  ) {
    authRemoteDataSource.otpSignIn(
      email = email,
      captchaToken = captchaToken.value,
    )
  }

  override suspend fun otpSignUp(
    email: String,
    captchaToken: CaptchaToken,
  ) {
    authRemoteDataSource.otpSignUp(
      email = email,
      captchaToken = captchaToken.value,
    )
  }

  override suspend fun verifyOtp(
    email: String,
    otp: String,
    captchaToken: CaptchaToken,
  ) {
    authRemoteDataSource.verifyOtp(
      email = email,
      otp = otp,
      captchaToken = captchaToken.value,
    )
  }

  override suspend fun googleSignIn() {
    authRemoteDataSource.googleSignIn()
  }

  override suspend fun googleSignUp() {
    authRemoteDataSource.googleSignUp()
  }

  override suspend fun anonymousSignIn(captchaToken: CaptchaToken) {
    authRemoteDataSource.anonymousSignIn(captchaToken = captchaToken.value)
  }

  override suspend fun logout() {
    authRemoteDataSource.logout()
  }

  override suspend fun hasCurrentSession(): Boolean {
    return authRemoteDataSource.hasCurrentSession()
  }
}
