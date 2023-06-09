package app.doggy.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
  tableName = "book_authors",
  primaryKeys = ["book_id", "author_id"],
  foreignKeys = [
    ForeignKey(
      entity = BookEntity::class,
      parentColumns = ["id"],
      childColumns = ["book_id"],
      onDelete = ForeignKey.CASCADE,
    ),
    ForeignKey(
      entity = AuthorEntity::class,
      parentColumns = ["id"],
      childColumns = ["author_id"],
      onDelete = ForeignKey.CASCADE,
    ),
  ],
  indices = [
    Index(value = ["book_id"]),
    Index(value = ["author_id"]),
  ],
)
data class BookAuthorCrossRef(
  @ColumnInfo(name = "book_id")
  val bookId: Long,
  @ColumnInfo(name = "author_id")
  val authorId: Long,
)
