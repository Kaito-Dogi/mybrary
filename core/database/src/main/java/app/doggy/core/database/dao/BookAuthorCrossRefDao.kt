package app.doggy.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import app.doggy.core.database.entity.BookAuthorCrossRef

@Dao
interface BookAuthorCrossRefDao {
  @Insert
  fun insert(bookAuthorCrossRef: BookAuthorCrossRef): Long
}
