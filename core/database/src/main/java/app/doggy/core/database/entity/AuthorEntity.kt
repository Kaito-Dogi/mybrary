package app.doggy.core.database.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
  tableName = "authors",
  indices = [
    Index(
      value = ["name"],
      unique = true,
    ),
  ],
)
data class AuthorEntity(
  @PrimaryKey
  val id: String,
  val name: String,
)
