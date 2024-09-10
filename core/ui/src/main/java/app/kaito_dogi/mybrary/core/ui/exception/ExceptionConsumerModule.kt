package app.kaito_dogi.mybrary.core.ui.exception

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface ExceptionConsumerModule {
  @Singleton
  @Binds
  fun bindExceptionConsumer(exceptionHandler: ExceptionHandler): ExceptionConsumer
}
