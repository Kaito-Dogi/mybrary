package app.kaito_dogi.mybrary.core.data

import app.kaito_dogi.mybrary.core.domain.repository.LoginRepository
import app.kaito_dogi.mybrary.core.repository.mock.MockLoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface MockLoginRepositoryModule {
  @Singleton
  @Binds
  fun bindLoginRepository(impl: MockLoginRepository): LoginRepository
}
