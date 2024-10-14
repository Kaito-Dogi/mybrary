package app.kaito_dogi.mybrary.core.repository.di

import app.kaito_dogi.mybrary.core.domain.repository.MemoRepository
import app.kaito_dogi.mybrary.core.repository.DefaultMemoRepository
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
  fun bindMemoRepository(impl: DefaultMemoRepository): MemoRepository
}
