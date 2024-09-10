package app.kaito_dogi.mybrary.core.ui.exception

import kotlinx.coroutines.flow.StateFlow

interface ExceptionConsumer {
  val exception: StateFlow<Exception?>
  fun consumeException()
}
