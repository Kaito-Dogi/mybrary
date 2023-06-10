package app.doggy.core.database.dao

import androidx.room.Dao
import androidx.room.Upsert
import app.doggy.core.database.entity.AuthorEntity

@Dao
interface AuthorDao {

  @Upsert
  suspend fun upsertAuthor(authorEntity: AuthorEntity): Long
}
