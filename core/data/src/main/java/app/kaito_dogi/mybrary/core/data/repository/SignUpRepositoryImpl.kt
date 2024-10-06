package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAnonApi
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatchers
import app.kaito_dogi.mybrary.core.domain.model.HCaptchaToken
import app.kaito_dogi.mybrary.core.domain.repository.SignUpRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

@Singleton
internal class SignUpRepositoryImpl @Inject constructor(
  private val mybraryAnonApi: MybraryAnonApi,
  @MybraryDispatcher(MybraryDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : SignUpRepository {
  override suspend fun googleSignUp() = withContext(dispatcher) {
    TODO("Not yet implemented")
  }

  override suspend fun anonymousSignUp(hCaptchaToken: HCaptchaToken) {
    mybraryAnonApi.anonymousSignUp(hCaptchaToken = hCaptchaToken.value)
  }
}
