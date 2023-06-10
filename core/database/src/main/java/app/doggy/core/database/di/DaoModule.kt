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
  fun provideAuthorDao(db: MybraryDatabase) = db.authorDao()

  @Provides
  fun provideBookAuthorCrossRefDao(db: MybraryDatabase) = db.bookAuthorCrossRefDao()

  @Provides
  fun provideBookDao(db: MybraryDatabase) = db.bookDao()

  @Provides
  fun provideRecordDao(db: MybraryDatabase) = db.recordDao()
}
