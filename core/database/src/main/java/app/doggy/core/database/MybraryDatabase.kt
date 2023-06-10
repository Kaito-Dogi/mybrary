package app.doggy.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.doggy.core.database.converter.BookStatusConverter
import app.doggy.core.database.dao.AuthorDao
import app.doggy.core.database.dao.BookAuthorCrossRefDao
import app.doggy.core.database.dao.BookDao
import app.doggy.core.database.dao.RecordDao
import app.doggy.core.database.entity.AuthorEntity
import app.doggy.core.database.entity.BookAuthorCrossRef
import app.doggy.core.database.entity.BookEntity
import app.doggy.core.database.entity.RecordEntity

@Database(
  entities = [
    AuthorEntity::class,
    BookAuthorCrossRef::class,
    BookEntity::class,
    RecordEntity::class,
  ],
  version = 1,
  exportSchema = true,
)
@TypeConverters(
  BookStatusConverter::class,
)
abstract class MybraryDatabase : RoomDatabase() {
  abstract fun authorDao(): AuthorDao
  abstract fun bookAuthorCrossRefDao(): BookAuthorCrossRefDao
  abstract fun bookDao(): BookDao
  abstract fun recordDao(): RecordDao
}
