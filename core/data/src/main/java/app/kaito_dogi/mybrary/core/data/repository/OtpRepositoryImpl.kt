package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.api.mybrary.MybraryAnonApi
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostSendOtpRequest
import app.kaito_dogi.mybrary.core.api.mybrary.request.PostVerifyOtpRequest
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatcher
import app.kaito_dogi.mybrary.core.common.coroutines.MybraryDispatchers
import app.kaito_dogi.mybrary.core.domain.repository.OtpRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

@Singleton
internal class OtpRepositoryImpl @Inject constructor(
  private val mybraryAnonApi: MybraryAnonApi,
  @MybraryDispatcher(MybraryDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) : OtpRepository {
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
}
