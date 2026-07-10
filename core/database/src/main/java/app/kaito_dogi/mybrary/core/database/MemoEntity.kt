package app.kaito_dogi.mybrary.core.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
  tableName = "memo",
  indices = [Index(value = ["my_book_id"])],
)
data class MemoEntity(
  @PrimaryKey
  val id: String,
  @ColumnInfo(name = "my_book_id")
  val myBookId: String,
  val content: String,
  @ColumnInfo(name = "start_page")
  val startPage: Int?,
  @ColumnInfo(name = "end_page")
  val endPage: Int?,
  @ColumnInfo(name = "created_at")
  val createdAt: Long,
  @ColumnInfo(name = "edited_at")
  val editedAt: Long?,
)
