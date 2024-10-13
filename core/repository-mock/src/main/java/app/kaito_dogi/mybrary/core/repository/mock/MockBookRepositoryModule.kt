package app.kaito_dogi.mybrary.core.repository.mock

import app.kaito_dogi.mybrary.core.domain.repository.BookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface MockBookRepositoryModule {
  @Singleton
  @Binds
  fun bindBookRepository(mock: MockBookRepository): BookRepository
}
