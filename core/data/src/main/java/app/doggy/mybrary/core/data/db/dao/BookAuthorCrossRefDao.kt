package app.doggy.mybrary.core.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import app.doggy.mybrary.core.data.db.entity.BookAuthorCrossRef

@Dao
interface BookAuthorCrossRefDao {
  @Insert
  fun insert(bookAuthorCrossRef: BookAuthorCrossRef): Long
}
