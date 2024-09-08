package app.kaito_dogi.mybrary.core.data

import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatchers
import app.kaito_dogi.mybrary.core.domain.repository.SignUpRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

@Singleton
internal class MockSignUpRepository @Inject constructor(
  @MybraryDispatcher(MybraryDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : SignUpRepository {
  override suspend fun googleSignUp() = withContext(dispatcher) {
    TODO("Not yet implemented")
  }
}
