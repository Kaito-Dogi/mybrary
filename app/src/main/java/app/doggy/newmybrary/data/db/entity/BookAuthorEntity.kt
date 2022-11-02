package app.doggy.newmybrary.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookAuthorEntity(
  @PrimaryKey val id: Int,
  @ColumnInfo(name = "book_id") val bookId: Int,
  @ColumnInfo(name = "author_id") val authorId: Int,
)
