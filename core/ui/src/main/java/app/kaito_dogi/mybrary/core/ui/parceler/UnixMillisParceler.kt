package app.kaito_dogi.mybrary.core.ui.parceler

import android.os.Parcel
import app.kaito_dogi.mybrary.core.domain.model.UnixMillis
import kotlinx.parcelize.Parceler
import kotlinx.serialization.json.Json

object UnixMillisParceler : Parceler<UnixMillis> {
  override fun create(parcel: Parcel): UnixMillis {
    val string = parcel.readString()!!
    return Json.decodeFromString(UnixMillis.serializer(), string)
  }

  override fun UnixMillis.write(parcel: Parcel, flags: Int) {
    val json = Json.encodeToString(UnixMillis.serializer(), this)
    parcel.writeString(json)
  }
}
