package app.kaito_dogi.mybrary.core.repository.di

import app.kaito_dogi.mybrary.core.domain.repository.BookRepository
import app.kaito_dogi.mybrary.core.repository.DefaultBookRepository
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
  fun bindBookRepository(impl: DefaultBookRepository): BookRepository
}
