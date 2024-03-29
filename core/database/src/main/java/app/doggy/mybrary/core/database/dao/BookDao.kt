package app.doggy.mybrary.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import app.doggy.mybrary.core.database.entity.BookEntity
import app.doggy.mybrary.core.database.entity.BookWithAuthors
import app.doggy.mybrary.core.database.entity.BookWithAuthorsWithRecords
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

  @Upsert
  suspend fun upsertBook(book: BookEntity): Long

  @Query("DELETE FROM books WHERE id = :bookId")
  suspend fun deleteBookById(bookId: Long)

  @Transaction
  @Query("SELECT * FROM books")
  fun getAllBooks(): Flow<List<BookWithAuthors>>

  @Transaction
  @Query("SELECT * FROM books WHERE id = :bookId")
  fun getBookById(bookId: Long): Flow<BookWithAuthors>

  @Transaction
  @Query("SELECT * FROM books WHERE id = :bookId")
  fun getBookWithRecordById(bookId: Long): Flow<BookWithAuthorsWithRecords>
}
