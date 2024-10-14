package app.kaito_dogi.mybrary.core.repository

import app.kaito_dogi.mybrary.core.data.datasource.AuthRemoteDataSource
import app.kaito_dogi.mybrary.core.domain.model.HCaptchaToken
import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import javax.inject.Inject

internal class DefaultAuthRepository @Inject constructor(
  private val authRemoteDataSource: AuthRemoteDataSource,
) : AuthRepository {
  override suspend fun sendOtp(
    email: String,
    captchaToken: HCaptchaToken,
  ) {
    authRemoteDataSource.sendOtp(
      email = email,
      captchaToken = captchaToken.value,
    )
  }

  override suspend fun verifyOtp(
    email: String,
    otp: String,
    captchaToken: HCaptchaToken,
  ) {
    authRemoteDataSource.verifyOtp(
      email = email,
      otp = otp,
      captchaToken = captchaToken.value,
    )
  }

  override suspend fun googleSignIn() {
    TODO("Not yet implemented")
  }

  override suspend fun anonymousSignIn(captchaToken: HCaptchaToken) {
    authRemoteDataSource.anonymousSignIn(captchaToken = captchaToken.value)
  }

  override suspend fun logout() {
    authRemoteDataSource.logout()
  }
}
