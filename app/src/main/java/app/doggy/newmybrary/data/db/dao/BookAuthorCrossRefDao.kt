package app.doggy.newmybrary.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import app.doggy.newmybrary.data.db.entity.BookAuthorCrossRef

@Dao
interface BookAuthorCrossRefDao {
  @Insert
  fun insert(bookAuthorCrossRef: BookAuthorCrossRef): Long
}
