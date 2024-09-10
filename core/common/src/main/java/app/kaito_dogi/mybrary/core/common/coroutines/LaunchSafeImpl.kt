package app.kaito_dogi.mybrary.core.common.coroutines

import app.kaito_dogi.mybrary.core.common.exception.ExceptionProducer
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@Singleton
internal class LaunchSafeImpl @Inject constructor(
  private val exceptionProducer: ExceptionProducer,
) : LaunchSafe {
  override fun CoroutineScope.launchSafe(
    context: CoroutineContext,
    start: CoroutineStart,
    block: suspend CoroutineScope.() -> Unit,
  ): Job = this.launch(
    context = context + exceptionProducer.coroutineExceptionHandler,
    start = start,
    block = block,
  )
}
