package app.kaito_dogi.mybrary.core.common.exception

class NetworkException(
  val code: Int,
  val errorBody: String,
) : Throwable()
