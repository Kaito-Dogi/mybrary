package app.kaito_dogi.mybrary.core.database.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DraftMemoDao {
  @Insert
  suspend fun insert(entity: DraftMemoEntity)

  @Update
  suspend fun update(entity: DraftMemoEntity)

  @Delete
  suspend fun delete(entity: DraftMemoEntity)

  @Query("SELECT * FROM draft_memos WHERE my_book_id = :myBookId")
  fun getByMyBookId(myBookId: Long): DraftMemoEntity
}
