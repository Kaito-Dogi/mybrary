package app.kaito_dogi.mybrary.core.data.repository

import app.kaito_dogi.mybrary.core.domain.repository.SearchBooksRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface SearchBooksRepositoryModule {
  @Singleton
  @Binds
  fun bindSearchBooksRepository(impl: SearchBooksRepositoryImpl): SearchBooksRepository
}
