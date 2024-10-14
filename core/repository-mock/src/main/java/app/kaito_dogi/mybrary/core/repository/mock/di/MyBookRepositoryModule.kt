package app.kaito_dogi.mybrary.core.repository.mock.di

import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import app.kaito_dogi.mybrary.core.repository.mock.MockMyBookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface MyBookRepositoryModule {
  @Singleton
  @Binds
  fun bindMyBookRepository(impl: MockMyBookRepository): MyBookRepository
}
