package app.doggy.mybrary.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.doggy.mybrary.core.data.db.dao.AuthorDao
import app.doggy.mybrary.core.data.db.dao.BookAuthorCrossRefDao
import app.doggy.mybrary.core.data.db.dao.BookDao
import app.doggy.mybrary.core.data.db.dao.DiaryDao
import app.doggy.mybrary.core.data.db.entity.AuthorEntity
import app.doggy.mybrary.core.data.db.entity.BookAuthorCrossRef
import app.doggy.mybrary.core.data.db.entity.BookEntity
import app.doggy.mybrary.core.data.db.entity.DiaryEntity

@Database(
  entities = [
    BookEntity::class,
    DiaryEntity::class,
    AuthorEntity::class,
    BookAuthorCrossRef::class,
  ],
  version = 2,
  exportSchema = true,
)
@TypeConverters(Converters::class)
abstract class MybraryDatabase : RoomDatabase() {
  abstract fun bookDao(): BookDao
  abstract fun diaryDao(): DiaryDao
  abstract fun authorDao(): AuthorDao
  abstract fun bookAuthorCrossRefDao(): BookAuthorCrossRefDao
}
