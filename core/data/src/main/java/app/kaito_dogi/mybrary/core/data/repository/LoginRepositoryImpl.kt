package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAnonApi
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostSendOneTimePasswordRequest
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.Dispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatchers
import app.kaito_dogi.mybrary.core.domain.repository.LoginRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

@Singleton
internal class LoginRepositoryImpl @Inject constructor(
  private val mybraryAnonApi: MybraryAnonApi,
  @Dispatcher(MybraryDispatchers.IO) private val dispatcher: CoroutineDispatcher,
) : LoginRepository {
  override suspend fun sendOneTimePassword(email: String) = withContext(dispatcher) {
    mybraryAnonApi.postSendOneTimePassword(
      request = PostSendOneTimePasswordRequest(email = email),
    )
  }

  override suspend fun googleLogin() {
    TODO("Not yet implemented")
  }
}
