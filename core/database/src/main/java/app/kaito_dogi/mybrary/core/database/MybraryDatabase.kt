package app.kaito_dogi.mybrary.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.kaito_dogi.mybrary.core.database.dao.AuthorDao
import app.kaito_dogi.mybrary.core.database.dao.BookDao
import app.kaito_dogi.mybrary.core.database.dao.RecordDao
import app.kaito_dogi.mybrary.core.database.entity.AuthorEntity
import app.kaito_dogi.mybrary.core.database.entity.BookEntity
import app.kaito_dogi.mybrary.core.database.entity.RecordEntity

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
