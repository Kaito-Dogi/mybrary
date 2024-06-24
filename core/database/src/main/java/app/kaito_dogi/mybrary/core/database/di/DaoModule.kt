package app.kaito_dogi.mybrary.core.database.di

import app.kaito_dogi.mybrary.core.database.MybraryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {
  @Singleton
  @Provides
  fun provideAuthorDao(db: MybraryDatabase) = db.authorDao()

  @Singleton
  @Provides
  fun provideBookDao(db: MybraryDatabase) = db.bookDao()

  @Singleton
  @Provides
  fun provideRecordDao(db: MybraryDatabase) = db.recordDao()
}
