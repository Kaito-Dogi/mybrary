package app.kaito_dogi.mybrary.core.database

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object MemoDaoModule {
  @Singleton
  @Provides
  fun provideMemoDao(db: MybraryDatabase) = db.memoDao()
}
