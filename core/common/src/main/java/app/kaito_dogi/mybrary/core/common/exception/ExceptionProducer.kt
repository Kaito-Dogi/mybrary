package app.kaito_dogi.mybrary.core.common.exception

import kotlinx.coroutines.CoroutineExceptionHandler

interface ExceptionProducer {
  val coroutineExceptionHandler: CoroutineExceptionHandler
}
