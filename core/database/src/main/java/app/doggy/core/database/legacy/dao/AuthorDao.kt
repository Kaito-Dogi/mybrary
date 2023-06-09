package app.doggy.core.database.legacy.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import app.doggy.core.database.legacy.entity.AuthorEntity

@Dao
interface AuthorDao {
  @Insert
  fun insert(author: AuthorEntity): Long

  @Update
  fun update(author: AuthorEntity): Int

  @Query("SELECT * FROM authors WHERE name = :name")
  fun getByName(name: String): AuthorEntity
}
