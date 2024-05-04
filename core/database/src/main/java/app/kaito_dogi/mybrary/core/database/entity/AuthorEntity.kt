package app.kaito_dogi.mybrary.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
  tableName = "authors",
  foreignKeys = [
    androidx.room.ForeignKey(
      entity = BookEntity::class,
      parentColumns = ["id"],
      childColumns = ["book_id"],
      onDelete = androidx.room.ForeignKey.CASCADE,
    ),
  ],
  indices = [
    Index(value = ["book_id"]),
  ],
)
data class AuthorEntity(
  @PrimaryKey
  val id: Long,
  @ColumnInfo(name = "book_id")
  val bookId: Long,
  val name: String,
)
