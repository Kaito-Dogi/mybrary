package app.kaito_dogi.mybrary.core.ui

import android.os.Parcel
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import kotlinx.parcelize.Parceler
import kotlinx.serialization.json.Json

object MyBookIdParceler : Parceler<MyBookId> {
  override fun create(parcel: Parcel): MyBookId {
    val string = parcel.readString()!!
    return Json.decodeFromString(MyBookId.serializer(), string)
  }

  override fun MyBookId.write(
    parcel: Parcel,
    flags: Int,
  ) {
    val json = Json.encodeToString(MyBookId.serializer(), this)
    parcel.writeString(json)
  }
}
