package app.doggy.newmybrary.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import app.doggy.newmybrary.domain.model.Diary
import java.util.Date

@Entity(tableName = "diaries")
data class DiaryEntity(
  @PrimaryKey
  @ColumnInfo(name = "diary_id")
  val diaryId: Long,

  @ColumnInfo(name = "book_id")
  val bookId: Long,

  val content: String,

  @ColumnInfo(name = "current_page")
  val currentPage: Int,

  @ColumnInfo(name = "created_at")
  val createdAt: Date,
) {
  // FIXME: 変換メソッドの置き場を考える
  fun toDiary() = Diary(
    content = content,
    currentPage = currentPage,
    recordedAt = createdAt,
  )
}
