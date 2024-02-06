package app.doggy.mybrary.core.common.coroutines.dispatcher

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
internal object DispatcherModule {

  @Provides
  @Dispatcher(MybraryDispatchers.DEFAULT)
  fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

  @Provides
  @Dispatcher(MybraryDispatchers.IO)
  fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}
