package app.kaito_dogi.mybrary.core.database.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface DraftMemoDao {
  @Upsert
  suspend fun upsert(entity: DraftMemoEntity)

  @Query("DELETE FROM draft_memos WHERE my_book_id = :myBookId")
  suspend fun deleteByMyBookId(myBookId: Long)

  @Query("SELECT * FROM draft_memos WHERE my_book_id = :myBookId")
  fun getByMyBookId(myBookId: Long): DraftMemoEntity?
}
