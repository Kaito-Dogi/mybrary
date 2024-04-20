package app.doggy.mybrary.core.data.di

import app.doggy.mybrary.core.data.repository.MockBookRepository
import app.doggy.mybrary.core.domain.repository.BookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface MockBookRepositoryModule {

  @Binds
  fun bindsBookRepository(
    bookRepository: MockBookRepository,
  ): BookRepository
}
