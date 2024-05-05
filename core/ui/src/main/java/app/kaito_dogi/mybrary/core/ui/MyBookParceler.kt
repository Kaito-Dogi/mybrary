package app.kaito_dogi.mybrary.core.ui

import android.os.Parcel
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import kotlinx.parcelize.Parceler
import kotlinx.serialization.json.Json

object MyBookParceler : Parceler<MyBook> {
  override fun create(parcel: Parcel): MyBook {
    val string = parcel.readString()!!
    return Json.decodeFromString(MyBook.serializer(), string)
  }

  override fun MyBook.write(parcel: Parcel, flags: Int) {
    val json = Json.encodeToString(MyBook.serializer(), this)
    parcel.writeString(json)
  }
}
