package app.doggy.mybrary.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import app.doggy.mybrary.core.domain.model.Book

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
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "author_id")
  val authorId: Long,

  val name: String,
)

fun Book.toAuthorEntities() = this.authors.map { authorName ->
  AuthorEntity(
    authorId = 0L,
    name = authorName,
  )
}
