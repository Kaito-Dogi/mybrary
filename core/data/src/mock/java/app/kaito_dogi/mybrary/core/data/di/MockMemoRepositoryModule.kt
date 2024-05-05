package app.kaito_dogi.mybrary.core.data.di

import app.kaito_dogi.mybrary.core.data.repository.MockMemoRepository
import app.kaito_dogi.mybrary.core.domain.repository.MemoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface MockMemoRepositoryModule {

  @Binds
  fun bindsMemoRepository(
    memoRepository: MockMemoRepository,
  ): MemoRepository
}
