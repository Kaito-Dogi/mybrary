package app.doggy.newmybrary.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import app.doggy.newmybrary.data.db.entity.DiaryEntity

@Dao
interface DiaryDao {
  fun insert(diary: DiaryEntity): Long

  @Update
  fun update(diary: DiaryEntity): Int

  @Query("SELECT * FROM diaries WHERE diary_id = :id")
  fun getDiary(id: Long): DiaryEntity
}
