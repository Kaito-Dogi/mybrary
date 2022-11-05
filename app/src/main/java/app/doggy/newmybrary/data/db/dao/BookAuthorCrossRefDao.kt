package app.doggy.newmybrary.data.db.dao

import androidx.room.Dao
import app.doggy.newmybrary.data.db.entity.BookAuthorCrossRef

@Dao
interface BookAuthorCrossRefDao {
  fun insert(bookAuthorCrossRef: BookAuthorCrossRef): Long
}
