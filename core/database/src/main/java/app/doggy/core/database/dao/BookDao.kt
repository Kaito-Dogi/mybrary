package app.doggy.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import app.doggy.core.database.entity.BookEntity
import app.doggy.core.database.entity.BookWithDiariesAndAuthors

@Dao
interface BookDao {
  @Insert
  fun insert(book: BookEntity): Long

  @Update
  fun update(book: BookEntity): Int

  @Transaction
  @Query("SELECT * FROM books")
  fun getAll(): List<BookWithDiariesAndAuthors>

  @Transaction
  @Query("SELECT * FROM books WHERE book_id = :id")
  fun getBook(id: Long): BookWithDiariesAndAuthors
}
