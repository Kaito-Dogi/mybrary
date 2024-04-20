package app.doggy.mybrary.core.database

import androidx.room.TypeConverter
import app.doggy.mybrary.core.database.entity.BookStatus

internal class BookStatusConverter {
  @TypeConverter
  fun bookStatusToString(status: BookStatus?): String? = status?.let { status.name }

  @TypeConverter
  fun stringToBookStatus(value: String?): BookStatus? = when (value) {
    null -> null
    else -> BookStatus.entries.firstOrNull { it.name == value }
  }
}
