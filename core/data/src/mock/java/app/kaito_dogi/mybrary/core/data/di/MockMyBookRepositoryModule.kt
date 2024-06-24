package app.kaito_dogi.mybrary.core.data.di

import app.kaito_dogi.mybrary.core.data.repository.MockMyBookRepository
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface MockMyBookRepositoryModule {
  @Singleton
  @Binds
  fun bindsMyBookRepository(
    mock: MockMyBookRepository,
  ): MyBookRepository
}
