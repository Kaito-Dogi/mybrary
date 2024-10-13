package app.kaito_dogi.mybrary.core.repository.mock

import app.kaito_dogi.mybrary.core.domain.repository.OtpRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface MockOtpRepositoryModule {
  @Singleton
  @Binds
  fun bindOtpRepository(impl: MockOtpRepository): OtpRepository
}
