package app.kaito_dogi.mybrary.core.data

import app.kaito_dogi.mybrary.core.domain.repository.DraftMemoRepository
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
  fun bindsDraftMemoRepository(
    draftMemoRepository: DraftMemoRepositoryImpl,
  ): DraftMemoRepository
}
