package app.kaito_dogi.mybrary.core.common.coroutines

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface LaunchSafeModule {
  @Singleton
  @Binds
  fun bindLaunchSafe(impl: LaunchSafeImpl): LaunchSafe
}
