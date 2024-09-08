package app.kaito_dogi.mybrary.core.ui.exception

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface ExceptionConsumerEntryPoint {
  fun exceptionConsumer(): ExceptionConsumer
}
