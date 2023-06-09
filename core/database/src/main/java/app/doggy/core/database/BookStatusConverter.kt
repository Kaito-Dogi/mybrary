package app.doggy.core.database

import androidx.room.TypeConverter
import app.doggy.mybrary.core.domain.model.book.BookStatus

class BookStatusConverter {
  @TypeConverter
  fun bookStatusToString(value: BookStatus?): String? = value?.let { value.name }

  @TypeConverter
  fun stringToBookStatus(value: String?): BookStatus = when (value) {
    null -> BookStatus.UNKNOWN
    else -> BookStatus.values().firstOrNull { it.name == value } ?: BookStatus.UNKNOWN
  }
}
