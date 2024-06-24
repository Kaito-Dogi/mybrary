package app.kaito_dogi.mybrary.core.common.coroutines.dispatcher

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
internal object DispatcherModule {
  @Dispatcher(MybraryDispatchers.DEFAULT)
  @Provides
  fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

  @Dispatcher(MybraryDispatchers.IO)
  @Provides
  fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}
