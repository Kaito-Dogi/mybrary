package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.Dispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatchers
import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@Singleton
internal class MockAuthRepository @Inject constructor(
  @Dispatcher(MybraryDispatchers.IO) private val dispatcher: CoroutineDispatcher,
) : AuthRepository {
  override suspend fun sendOtp(email: String) = withContext(dispatcher) {
    delay(1_000)
  }

  override suspend fun verifyOtp(email: String, otp: String) = withContext(dispatcher) {
    delay(1_000)
  }

  override suspend fun googleLogin() {
    TODO("Not yet implemented")
  }

  override suspend fun hasSession(): Boolean = withContext(dispatcher) {
    return@withContext false
  }
}
