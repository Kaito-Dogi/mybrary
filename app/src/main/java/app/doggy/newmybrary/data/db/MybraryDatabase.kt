package app.doggy.newmybrary.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.doggy.newmybrary.data.db.dao.AuthorDao
import app.doggy.newmybrary.data.db.dao.BookDao
import app.doggy.newmybrary.data.db.dao.DiaryDao
import app.doggy.newmybrary.data.db.entity.AuthorEntity
import app.doggy.newmybrary.data.db.entity.BookAuthorCrossRef
import app.doggy.newmybrary.data.db.entity.BookEntity
import app.doggy.newmybrary.data.db.entity.DiaryEntity

@Database(
  entities = [
    BookEntity::class,
    DiaryEntity::class,
    AuthorEntity::class,
    BookAuthorCrossRef::class,
  ],
  version = 1,
  exportSchema = true,
)
@TypeConverters(Converters::class)
abstract class MybraryDatabase : RoomDatabase() {
  abstract fun bookDao(): BookDao
  abstract fun diaryDao(): DiaryDao
  abstract fun authorDao(): AuthorDao
}
