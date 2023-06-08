package app.doggy.core.database.di

import app.doggy.core.database.MybraryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DaoModule {
  @Provides
  fun provideBookDao(db: MybraryDatabase) = db.bookDao()

  @Provides
  fun provideDiaryDao(db: MybraryDatabase) = db.diaryDao()

  @Provides
  fun provideAuthorDao(db: MybraryDatabase) = db.authorDao()
}
