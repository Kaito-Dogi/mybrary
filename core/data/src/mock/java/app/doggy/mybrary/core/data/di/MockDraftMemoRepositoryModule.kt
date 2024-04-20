package app.doggy.mybrary.core.data.di

import app.doggy.mybrary.core.data.repository.MockDraftMemoRepository
import app.doggy.mybrary.core.domain.repository.DraftMemoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface MockDraftMemoRepositoryModule {

  @Binds
  fun bindsDraftMemoRepository(
    draftMemoRepository: MockDraftMemoRepository,
  ): DraftMemoRepository
}
