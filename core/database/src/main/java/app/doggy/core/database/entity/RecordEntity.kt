package app.doggy.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import app.doggy.core.common.util.UnixTime
import app.doggy.mybrary.core.domain.model.record.Record
import app.doggy.mybrary.core.domain.model.record.RecordId

@Entity(
  tableName = "records",
  foreignKeys = [
    ForeignKey(
      entity = BookEntity::class,
      parentColumns = ["id"],
      childColumns = ["book_id"],
      onDelete = ForeignKey.CASCADE,
    ),
  ],
  indices = [
    Index(value = ["book_id"]),
  ],
)
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
) {
  fun toRecord() = Record(
    id = RecordId(id),
    memo = memo,
    startPage = startPage,
    endPage = endPage,
    recordedAt = UnixTime(recordedAt),
  )
}
