package app.kaito_dogi.mybrary.core.data

import app.kaito_dogi.mybrary.core.data.repository.SignUpRepositoryImpl
import app.kaito_dogi.mybrary.core.domain.repository.SignUpRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface SignUpRepositoryModule {
  @Singleton
  @Binds
  fun bindSignUpRepository(impl: SignUpRepositoryImpl): SignUpRepository
}
