package app.kaito_dogi.mybrary.core.repository.di

import app.kaito_dogi.mybrary.core.domain.repository.DraftMemoRepository
import app.kaito_dogi.mybrary.core.repository.DefaultDraftMemoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface DraftMemoRepositoryModule {
  @Singleton
  @Binds
  fun bindDraftMemoRepository(impl: DefaultDraftMemoRepository): DraftMemoRepository
}
