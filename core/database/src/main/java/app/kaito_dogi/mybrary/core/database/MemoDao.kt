package app.kaito_dogi.mybrary.core.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface MemoDao {
  @Upsert
  suspend fun upsert(entity: MemoEntity)

  @Query("SELECT * FROM memo WHERE my_book_id = :myBookId ORDER BY created_at ASC")
  suspend fun getByMyBookId(myBookId: String): List<MemoEntity>

  @Query("SELECT * FROM memo WHERE id = :id")
  suspend fun getById(id: String): MemoEntity?
}
