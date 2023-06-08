package app.doggy.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.doggy.core.database.dao.AuthorDao
import app.doggy.core.database.dao.BookAuthorCrossRefDao
import app.doggy.core.database.dao.BookDao
import app.doggy.core.database.dao.DiaryDao
import app.doggy.core.database.entity.AuthorEntity
import app.doggy.core.database.entity.BookAuthorCrossRef
import app.doggy.core.database.entity.BookEntity
import app.doggy.core.database.entity.DiaryEntity

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
