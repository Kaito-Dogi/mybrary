package app.kaito_dogi.mybrary.core.data

import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatchers
import app.kaito_dogi.mybrary.core.domain.repository.LoginRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@Singleton
internal class MockLoginRepository @Inject constructor(
  @MybraryDispatcher(MybraryDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : LoginRepository {
  override suspend fun googleLogin() = withContext(dispatcher) {
    delay(1_000L)
  }

  override suspend fun anonymousLogin() = withContext(dispatcher) {
    delay(1_000L)
  }
}
