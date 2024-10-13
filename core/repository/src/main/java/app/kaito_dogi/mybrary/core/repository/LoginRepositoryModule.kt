package app.kaito_dogi.mybrary.core.repository

import app.kaito_dogi.mybrary.core.domain.repository.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface LoginRepositoryModule {
  @Singleton
  @Binds
  fun bindLoginRepository(impl: LoginRepositoryImpl): LoginRepository
}
