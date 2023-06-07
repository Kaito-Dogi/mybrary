package app.doggy.mybrary.core.data.db

import androidx.room.TypeConverter
import java.util.Date

class Converters {
  @TypeConverter
  fun fromLongToDate(value: Long?): Date? = value?.let { Date(it) }

  @TypeConverter
  fun fromDateToLong(value: Date?): Long? = value?.time
}
