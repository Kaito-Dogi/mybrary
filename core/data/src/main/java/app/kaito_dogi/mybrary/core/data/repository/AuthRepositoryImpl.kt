package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAnonApi
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostSendOtpRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostVerifyOtpRequest
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.Dispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.dispatcher.MybraryDispatchers
import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

@Singleton
internal class AuthRepositoryImpl @Inject constructor(
  private val mybraryAnonApi: MybraryAnonApi,
  @Dispatcher(MybraryDispatchers.IO) private val dispatcher: CoroutineDispatcher,
) : AuthRepository {
  override suspend fun sendOtp(email: String) = withContext(dispatcher) {
    mybraryAnonApi.postSendOtp(
      request = PostSendOtpRequest(email = email),
    )
  }

  override suspend fun verifyOtp(
    email: String,
    otp: String,
  ) = withContext(dispatcher) {
    mybraryAnonApi.postVerifyOtp(
      request = PostVerifyOtpRequest(
        email = email,
        otp = otp,
      ),
    )
  }

  override suspend fun googleLogin() {
    TODO("Not yet implemented")
  }

  override suspend fun hasSession(): Boolean = withContext(dispatcher) {
    return@withContext mybraryAnonApi.getSession()
  }
}
