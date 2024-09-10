package app.kaito_dogi.mybrary.core.common.coroutines

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
internal object DefaultDispatcherModule {
  @MybraryDispatcher(MybraryDispatchers.Default)
  @Provides
  fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}
