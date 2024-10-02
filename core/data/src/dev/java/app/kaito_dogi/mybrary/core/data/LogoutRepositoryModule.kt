package app.kaito_dogi.mybrary.core.data

import app.kaito_dogi.mybrary.core.data.repository.LogoutRepositoryImpl
import app.kaito_dogi.mybrary.core.domain.repository.LogoutRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface LogoutRepositoryModule {
  @Singleton
  @Binds
  fun bindLogoutRepository(impl: LogoutRepositoryImpl): LogoutRepository
}
