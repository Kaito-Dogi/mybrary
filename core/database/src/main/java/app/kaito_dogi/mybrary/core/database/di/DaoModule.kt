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
  fun providesAuthorDao(db: MybraryDatabase) = db.authorDao()

  @Singleton
  @Provides
  fun providesBookDao(db: MybraryDatabase) = db.bookDao()

  @Singleton
  @Provides
  fun providesRecordDao(db: MybraryDatabase) = db.recordDao()
}
