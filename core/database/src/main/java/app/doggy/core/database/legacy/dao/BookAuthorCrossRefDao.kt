package app.doggy.core.database.legacy.dao

import androidx.room.Dao
import androidx.room.Insert
import app.doggy.core.database.legacy.entity.BookAuthorCrossRef

@Dao
interface BookAuthorCrossRefDao {
  @Insert
  fun insert(bookAuthorCrossRef: BookAuthorCrossRef): Long
}
