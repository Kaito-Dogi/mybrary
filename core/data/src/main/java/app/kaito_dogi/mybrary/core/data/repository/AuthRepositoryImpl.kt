package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAnonApi
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatchers
import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

@Singleton
internal class AuthRepositoryImpl @Inject constructor(
  private val mybraryAnonApi: MybraryAnonApi,
  @MybraryDispatcher(MybraryDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : AuthRepository {
  override suspend fun hasSession(): Boolean = withContext(dispatcher) {
    return@withContext mybraryAnonApi.getSession()
  }
}
