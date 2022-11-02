package app.doggy.newmybrary.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class BookEntity(
  @PrimaryKey val id: Long,
  val title: String,
  val description: String,
  @ColumnInfo(name = "total_page") val totalPage: Int,
  @ColumnInfo(name = "image_url") val imageUrl: String,
  @ColumnInfo(name = "created_at") val createdAt: Date,
)
