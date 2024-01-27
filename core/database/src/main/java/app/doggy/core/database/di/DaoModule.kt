package app.doggy.core.database.di

import app.doggy.core.database.MybraryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

  @Provides
  fun providesAuthorDao(db: MybraryDatabase) = db.authorDao()

  @Provides
  fun providesBookDao(db: MybraryDatabase) = db.bookDao()

  @Provides
  fun providesRecordDao(db: MybraryDatabase) = db.recordDao()
}
