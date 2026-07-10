package app.kaito_dogi.mybrary.core.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_book")
data class MyBookEntity(
  @PrimaryKey
  val id: String,
  val title: String,
  @ColumnInfo(name = "image_url")
  val imageUrl: String,
  // 「/」区切りで著者名を保持する
  val authors: String,
  val publisher: String,
  val isbn: String,
  val genre: Int,
  @ColumnInfo(name = "rakuten_url", defaultValue = "")
  val rakutenUrl: String,
  @ColumnInfo(name = "is_pinned")
  val isPinned: Boolean,
  @ColumnInfo(name = "is_favorite")
  val isFavorite: Boolean,
  @ColumnInfo(name = "is_archived")
  val isArchived: Boolean,
  @ColumnInfo(name = "created_at")
  val createdAt: Long,
)
