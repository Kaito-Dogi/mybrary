package app.kaito_dogi.mybrary.core.repository.mock

import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface AuthRepositoryModule {
  @Singleton
  @Binds
  fun bindAuthRepository(impl: MockAuthRepository): AuthRepository
}
