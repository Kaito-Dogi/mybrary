package app.doggy.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.doggy.core.database.converter.BookStatusConverter
import app.doggy.core.database.converter.UnixTimeConverter
import app.doggy.core.database.legacy.dao.AuthorDao
import app.doggy.core.database.legacy.dao.BookAuthorCrossRefDao
import app.doggy.core.database.legacy.dao.BookDao
import app.doggy.core.database.legacy.dao.DiaryDao
import app.doggy.core.database.legacy.entity.AuthorEntity
import app.doggy.core.database.legacy.entity.BookAuthorCrossRef
import app.doggy.core.database.legacy.entity.BookEntity
import app.doggy.core.database.legacy.entity.DiaryEntity

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
@TypeConverters(
  BookStatusConverter::class,
  UnixTimeConverter::class,
)
abstract class MybraryDatabase : RoomDatabase() {
  abstract fun bookDao(): BookDao
  abstract fun diaryDao(): DiaryDao
  abstract fun authorDao(): AuthorDao
  abstract fun bookAuthorCrossRefDao(): BookAuthorCrossRefDao
}
