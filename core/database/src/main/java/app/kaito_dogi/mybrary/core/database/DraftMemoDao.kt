package app.kaito_dogi.mybrary.core.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface DraftMemoDao {
  @Insert
  suspend fun insertDraftMemo(draftMemo: DraftMemoEntity): Long

  @Update
  suspend fun updateDraftMemo(draftMemo: DraftMemoEntity)

  @Delete
  suspend fun deleteDraftMemo(draftMemo: DraftMemoEntity)
}
