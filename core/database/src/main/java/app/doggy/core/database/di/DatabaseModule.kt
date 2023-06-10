package app.doggy.core.database.di

import android.content.Context
import androidx.room.Room
import app.doggy.core.database.MIGRATION_1_2
import app.doggy.core.database.MybraryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

  @Provides
  @Singleton
  fun providesMybraryDatabase(
    @ApplicationContext context: Context,
  ): MybraryDatabase = Room.databaseBuilder(
    context,
    MybraryDatabase::class.java,
    "mybrary_db",
  )
    .addMigrations(
      MIGRATION_1_2,
    )
    .build()
}
