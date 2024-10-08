package app.kaito_dogi.mybrary.core.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "draft_memo")
data class DraftMemoEntity(
  @PrimaryKey
  @ColumnInfo(name = "my_book_id")
  val myBookId: String,
  val content: String,
  @ColumnInfo(name = "start_page")
  val startPage: Int?,
  @ColumnInfo(name = "end_page")
  val endPage: Int?,
)
