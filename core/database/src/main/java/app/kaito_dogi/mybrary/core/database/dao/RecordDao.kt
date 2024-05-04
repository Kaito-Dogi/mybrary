package app.kaito_dogi.mybrary.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import app.kaito_dogi.mybrary.core.database.entity.RecordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecordDao {

  @Upsert
  suspend fun upsertRecord(record: RecordEntity): Long

  @Query("DELETE FROM records  WHERE id = :recordId")
  suspend fun deleteRecordById(recordId: Long)

  @Query("SELECT * FROM records WHERE id = :recordId")
  fun getRecordById(recordId: Long): Flow<RecordEntity>
}
