package app.kaito_dogi.mybrary.core.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface DraftMemoDao {
  @Upsert
  suspend fun upsert(entity: DraftMemoEntity)

  @Query("DELETE FROM draft_memo WHERE my_book_id = :myBookId")
  suspend fun deleteByMyBookId(myBookId: String)

  @Query("SELECT * FROM draft_memo WHERE my_book_id = :myBookId")
  fun getByMyBookId(myBookId: String): DraftMemoEntity?
}
