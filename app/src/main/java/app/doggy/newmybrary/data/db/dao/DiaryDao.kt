package app.doggy.newmybrary.data.db.dao

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import app.doggy.newmybrary.data.db.entity.DiaryEntity

interface DiaryDao {
  @Insert
  fun insert(diary: DiaryEntity): Long

  @Update
  fun update(diary: DiaryEntity): Long

  @Query("SELECT * FROM diaries WHERE id = :id")
  fun getDiary(id: Long): DiaryEntity
}
