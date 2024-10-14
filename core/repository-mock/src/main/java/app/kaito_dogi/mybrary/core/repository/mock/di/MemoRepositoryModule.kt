package app.kaito_dogi.mybrary.core.repository.mock.di

import app.kaito_dogi.mybrary.core.domain.repository.MemoRepository
import app.kaito_dogi.mybrary.core.repository.mock.MockMemoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface MemoRepositoryModule {
  @Singleton
  @Binds
  fun bindMemoRepository(impl: MockMemoRepository): MemoRepository
}
