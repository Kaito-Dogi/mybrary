package app.kaito_dogi.mybrary.core.repository.mock.di

import app.kaito_dogi.mybrary.core.domain.repository.BookRepository
import app.kaito_dogi.mybrary.core.repository.mock.MockBookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface BookRepositoryModule {
  @Singleton
  @Binds
  fun bindBookRepository(mock: MockBookRepository): BookRepository
}
