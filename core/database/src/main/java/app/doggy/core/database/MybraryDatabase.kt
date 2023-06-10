package app.doggy.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.doggy.core.database.dao.AuthorDao
import app.doggy.core.database.dao.BookDao
import app.doggy.core.database.dao.RecordDao
import app.doggy.core.database.entity.AuthorEntity
import app.doggy.core.database.entity.BookEntity
import app.doggy.core.database.entity.RecordEntity

@Database(
  entities = [
    AuthorEntity::class,
    BookEntity::class,
    RecordEntity::class,
  ],
  version = 4,
  exportSchema = true,
)
@TypeConverters(
  BookStatusConverter::class,
)
abstract class MybraryDatabase : RoomDatabase() {
  abstract fun authorDao(): AuthorDao
  abstract fun bookDao(): BookDao
  abstract fun recordDao(): RecordDao
}
