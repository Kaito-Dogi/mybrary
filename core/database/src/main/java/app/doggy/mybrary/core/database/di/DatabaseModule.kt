package app.doggy.mybrary.core.database.di

import android.content.Context
import androidx.room.Room
import app.doggy.mybrary.core.database.MIGRATION_1_2
import app.doggy.mybrary.core.database.MIGRATION_2_3
import app.doggy.mybrary.core.database.MIGRATION_3_4
import app.doggy.mybrary.core.database.MybraryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

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
      MIGRATION_2_3,
      MIGRATION_3_4,
    )
    .build()
}
