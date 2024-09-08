package app.kaito_dogi.mybrary.core.ui.exception

import app.kaito_dogi.mybrary.core.common.exception.ExceptionProducer
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@Singleton
internal class ExceptionHandler @Inject constructor() : ExceptionProducer, ExceptionConsumer {
  private val _exception = MutableStateFlow<Exception?>(value = null)
  override val exception: StateFlow<Exception?> = _exception.asStateFlow()

  override val coroutineExceptionHandler: CoroutineExceptionHandler =
    CoroutineExceptionHandler { _, throwable -> handleException(throwable = throwable) }

  private fun handleException(throwable: Throwable) {
    // FIXME: デバッグ用のログに置き換える
    throwable.printStackTrace()

    produceException(throwable = throwable)
  }

  private fun produceException(throwable: Throwable) {
    when (throwable) {
      is CancellationException, is AssertionError -> return
      else -> {
        _exception.update { it }
      }
    }
  }

  override fun consumeException() {
    _exception.update { null }
  }
}
