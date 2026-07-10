package app.kaito_dogi.mybrary.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
  entities = [
    DraftMemoEntity::class,
    MyBookEntity::class,
    MemoEntity::class,
  ],
  version = 3,
  exportSchema = true,
)
internal abstract class MybraryDatabase : RoomDatabase() {
  abstract fun draftMemoDao(): DraftMemoDao

  abstract fun myBookDao(): MyBookDao

  abstract fun memoDao(): MemoDao
}
