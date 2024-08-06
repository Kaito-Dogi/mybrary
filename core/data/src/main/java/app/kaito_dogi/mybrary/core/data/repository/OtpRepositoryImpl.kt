package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.domain.repository.OtpRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class OtpRepositoryImpl @Inject constructor() : OtpRepository {
  override suspend fun verifyOtp(
    email: String,
    otp: String,
  ) {
    TODO("Not yet implemented")
  }
}
