package app.kaito_dogi.mybrary.core.database

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private val Migration2To3 = object : Migration(2, 3) {
  override fun migrate(db: SupportSQLiteDatabase) {
    db.execSQL("ALTER TABLE my_book ADD COLUMN rakuten_url TEXT NOT NULL DEFAULT ''")
  }
}

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
  @Singleton
  @Provides
  fun provideMybraryDatabase(
    @ApplicationContext context: Context,
  ): MybraryDatabase = Room.databaseBuilder(
    context = context,
    klass = MybraryDatabase::class.java,
    name = "mybrary-database",
  )
    .addMigrations(Migration2To3)
    .fallbackToDestructiveMigration(dropAllTables = false)
    .build()
}
