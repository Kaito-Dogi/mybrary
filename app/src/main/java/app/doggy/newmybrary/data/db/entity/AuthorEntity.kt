package app.doggy.newmybrary.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authors")
data class AuthorEntity(
  @PrimaryKey val id: Long,
  val name: String,
)