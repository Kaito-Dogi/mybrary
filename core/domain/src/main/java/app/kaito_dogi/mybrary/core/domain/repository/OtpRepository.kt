package app.kaito_dogi.mybrary.core.domain.repository

interface OtpRepository {
  suspend fun verifyOtp(
    email: String,
    otp: String,
  )
}
