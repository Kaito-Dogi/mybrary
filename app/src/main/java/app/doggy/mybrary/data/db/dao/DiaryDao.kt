package app.doggy.mybrary.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import app.doggy.mybrary.data.db.entity.DiaryEntity

@Dao
interface DiaryDao {
  @Insert
  fun insert(diary: DiaryEntity): Long

  @Update
  fun update(diary: DiaryEntity): Int

  @Query("SELECT * FROM diaries WHERE diary_id = :id")
  fun getById(id: Long): DiaryEntity
}
