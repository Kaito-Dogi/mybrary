package app.doggy.core.database.converter

import androidx.room.TypeConverter
import app.doggy.core.common.util.UnixTime

class UnixTimeConverter {
  @TypeConverter
  fun unixTimeToLong(unixTime: UnixTime?): Long? = unixTime?.value

  @TypeConverter
  fun longToUnixTime(value: Long?): UnixTime? = value?.let { UnixTime(value) }
}
