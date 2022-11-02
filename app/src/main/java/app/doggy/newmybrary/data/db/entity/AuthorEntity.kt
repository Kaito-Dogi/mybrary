package app.doggy.newmybrary.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authors")
data class AuthorEntity(
  @PrimaryKey
  @ColumnInfo(name = "author_id")
  val authorId: Long,

  val name: String,
)
