package app.doggy.mybrary.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import app.doggy.mybrary.core.domain.legacy.model.author.Author
import app.doggy.mybrary.core.domain.legacy.model.author.AuthorId
import app.doggy.mybrary.core.domain.legacy.model.book.BookId

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
) {
  fun toAuthor() = Author(
    id = AuthorId(id),
    name = name,
  )
}

internal fun Author.toEntity(bookId: BookId) = AuthorEntity(
  id = id.value,
  bookId = bookId.value,
  name = name,
)
