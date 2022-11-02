package app.doggy.newmybrary.data.db.dao

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import app.doggy.newmybrary.data.db.entity.DiaryEntity

interface DiaryDao {
  @Insert
  fun insert(diary: DiaryEntity): Int

  @Update
  fun update(diary: DiaryEntity): Int

  @Query("SELECT * FROM DiaryEntity WHERE id = :id")
  fun getDiary(id: Int): DiaryEntity
}
