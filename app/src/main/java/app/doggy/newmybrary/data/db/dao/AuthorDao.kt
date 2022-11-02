package app.doggy.newmybrary.data.db.dao

import androidx.room.Insert
import androidx.room.Update
import app.doggy.newmybrary.data.db.entity.AuthorEntity

interface AuthorDao {
  @Insert
  fun insert(author: AuthorEntity): Long

  @Update
  fun update(author: AuthorEntity): Long
}