package app.kaito_dogi.mybrary.core.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface MyBookDao {
  @Upsert
  suspend fun upsert(entity: MyBookEntity)

  @Query("SELECT * FROM my_book WHERE is_archived = 0 ORDER BY created_at DESC")
  suspend fun getAll(): List<MyBookEntity>

  @Query("SELECT * FROM my_book WHERE id = :id")
  suspend fun getById(id: String): MyBookEntity?

  @Query("SELECT * FROM my_book WHERE isbn = :isbn LIMIT 1")
  suspend fun getByIsbn(isbn: String): MyBookEntity?
}
