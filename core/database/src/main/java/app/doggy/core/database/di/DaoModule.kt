package app.doggy.core.database.di

import app.doggy.core.database.MybraryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

  @Provides
  fun providesAuthorDao(db: MybraryDatabase) = db.authorDao()

  @Provides
  fun providesBookAuthorCrossRefDao(db: MybraryDatabase) = db.bookAuthorCrossRefDao()

  @Provides
  fun providesBookDao(db: MybraryDatabase) = db.bookDao()

  @Provides
  fun providesRecordDao(db: MybraryDatabase) = db.recordDao()
}
