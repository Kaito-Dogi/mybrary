package app.doggy.mybrary.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import app.doggy.mybrary.core.database.entity.AuthorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthorDao {

  @Upsert
  suspend fun upsertAuthors(authors: List<AuthorEntity>): List<Long>

  @Delete
  suspend fun deleteAuthors(authors: List<AuthorEntity>)

  @Query("SELECT * FROM authors WHERE book_id = :bookId")
  fun getAuthorsByBookId(bookId: Long): Flow<List<AuthorEntity>>
}
