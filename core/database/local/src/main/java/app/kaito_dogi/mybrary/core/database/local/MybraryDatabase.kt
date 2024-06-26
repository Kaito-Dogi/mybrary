package app.kaito_dogi.mybrary.core.database.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
  entities = [DraftMemoEntity::class],
  version = 1,
  exportSchema = true,
)
internal abstract class MybraryDatabase : RoomDatabase() {
  abstract fun draftMemoDao(): DraftMemoDao
}
