package app.doggy.mybrary.core.data.di

import app.doggy.mybrary.core.data.repository.MockMyBookRepository
import app.doggy.mybrary.core.domain.repository.MyBookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface MockMyBookRepositoryModule {

  @Binds
  fun bindsMyBookRepository(
    myBookRepository: MockMyBookRepository,
  ): MyBookRepository
}
