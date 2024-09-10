package app.kaito_dogi.mybrary.core.ui.exception

import app.kaito_dogi.mybrary.core.common.exception.ExceptionProducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface ExceptionProducerModule {
  @Singleton
  @Binds
  fun bindExceptionProducer(exceptionHandler: ExceptionHandler): ExceptionProducer
}
