package app.kaito_dogi.mybrary.core.database

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DraftMemoDaoModule {
  @Singleton
  @Provides
  fun provideDraftMemoDao(db: MybraryDatabase) = db.draftMemoDao()
}
