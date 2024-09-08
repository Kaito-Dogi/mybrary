package app.kaito_dogi.mybrary.core.data

import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatchers
import app.kaito_dogi.mybrary.core.domain.repository.OtpRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@Singleton
internal class MockOtpRepository @Inject constructor(
  @MybraryDispatcher(MybraryDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : OtpRepository {
  override suspend fun sendOtp(email: String) = withContext(dispatcher) {
    delay(1_000)
  }

  override suspend fun verifyOtp(email: String, otp: String) = withContext(dispatcher) {
    delay(1_000)
  }
}
