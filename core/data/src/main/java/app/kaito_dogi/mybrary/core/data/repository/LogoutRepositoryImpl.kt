package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAnonApi
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatchers
import app.kaito_dogi.mybrary.core.domain.repository.LogoutRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

@Singleton
internal class LogoutRepositoryImpl @Inject constructor(
  private val mybraryAnonApi: MybraryAnonApi,
  @MybraryDispatcher(MybraryDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : LogoutRepository {
  override suspend fun logout() = withContext(dispatcher) {
    mybraryAnonApi.logout()
  }
}
