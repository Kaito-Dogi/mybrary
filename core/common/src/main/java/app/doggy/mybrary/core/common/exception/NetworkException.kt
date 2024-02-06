package app.doggy.mybrary.core.common.exception

class NetworkException(
  val code: Int,
  val errorBody: String,
) : Throwable()
