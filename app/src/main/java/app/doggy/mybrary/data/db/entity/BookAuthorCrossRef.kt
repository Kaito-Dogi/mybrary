package app.doggy.mybrary.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index

@Entity(
  primaryKeys = ["book_id", "author_id"],
  indices = [
    Index(
      value = ["book_id", "author_id"],
      unique = true,
    ),
  ],
)
data class BookAuthorCrossRef(
  @ColumnInfo(name = "book_id")
  val bookId: Long,

  @ColumnInfo(name = "author_id", index = true)
  val authorId: Long,
)
