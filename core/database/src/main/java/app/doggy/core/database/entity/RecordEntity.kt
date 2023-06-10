package app.doggy.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "records")
data class RecordEntity(
  @PrimaryKey
  val id: Long,
  @ColumnInfo(name = "book_id")
  val bookId: Long,
  val memo: String,
  @ColumnInfo(name = "start_page")
  val startPage: Int,
  @ColumnInfo(name = "end_page")
  val endPage: Int,
  @ColumnInfo(name = "recorded_at")
  val recordedAt: Long,
)
