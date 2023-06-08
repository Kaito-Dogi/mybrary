package app.doggy.core.common.exception

class NetworkException(
  val code: Int,
  val errorBody: String,
) : Throwable()
