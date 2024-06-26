package app.kaito_dogi.mybrary.core.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "draft_memos")
data class DraftMemoEntity(
  @PrimaryKey
  val id: Long,
  val content: String,
  @ColumnInfo(name = "from_page")
  val fromPage: Int?,
  @ColumnInfo(name = "to_page")
  val toPage: Int?,
)
