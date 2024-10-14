package app.kaito_dogi.mybrary.core.repository.mock.di

import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import app.kaito_dogi.mybrary.core.repository.mock.MockAuthRepository
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
