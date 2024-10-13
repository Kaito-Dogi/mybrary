package app.kaito_dogi.mybrary.core.repository

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAnonApi
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatchers
import app.kaito_dogi.mybrary.core.domain.model.HCaptchaToken
import app.kaito_dogi.mybrary.core.domain.repository.LoginRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

@Singleton
internal class LoginRepositoryImpl @Inject constructor(
  private val mybraryAnonApi: MybraryAnonApi,
  @MybraryDispatcher(MybraryDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : LoginRepository {
  override suspend fun googleLogin() = withContext(dispatcher) {
    TODO("Not yet implemented")
  }

  override suspend fun anonymousLogin(hCaptchaToken: HCaptchaToken) = withContext(dispatcher) {
    mybraryAnonApi.anonymousLogin(hCaptchaToken = hCaptchaToken.value)
  }
}
