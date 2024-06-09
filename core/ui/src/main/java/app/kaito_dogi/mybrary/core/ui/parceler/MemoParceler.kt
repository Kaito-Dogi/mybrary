package app.kaito_dogi.mybrary.core.ui.parceler

import android.os.Parcel
import app.kaito_dogi.mybrary.core.domain.model.Memo
import kotlinx.parcelize.Parceler
import kotlinx.serialization.json.Json

object MemoParceler : Parceler<Memo> {
  override fun create(parcel: Parcel): Memo {
    val string = parcel.readString()!!
    return Json.decodeFromString(Memo.serializer(), string)
  }

  override fun Memo.write(parcel: Parcel, flags: Int) {
    val json = Json.encodeToString(Memo.serializer(), this)
    parcel.writeString(json)
  }
}
