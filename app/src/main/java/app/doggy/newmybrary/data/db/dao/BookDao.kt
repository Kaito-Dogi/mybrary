package app.doggy.newmybrary.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import app.doggy.newmybrary.data.db.entity.BookWithDiariesAndAuthors

@Dao
interface BookDao {
  @Transaction
  @Query("SELECT * FROM BookEntity")
  fun getBookWithDiaries(): List<BookWithDiariesAndAuthors>
}
