package app.doggy.newmybrary.data.db.di

import android.content.Context
import androidx.room.Room
import app.doggy.newmybrary.data.db.MIGRATION_1_2
import app.doggy.newmybrary.data.db.MybraryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
  @Singleton
  @Provides
  fun provideMybraryDatabase(
    @ApplicationContext context: Context,
  ): MybraryDatabase = Room.databaseBuilder(context, MybraryDatabase::class.java, "mybrary_db")
    .fallbackToDestructiveMigration()
    .addMigrations(MIGRATION_1_2)
    .build()
}
