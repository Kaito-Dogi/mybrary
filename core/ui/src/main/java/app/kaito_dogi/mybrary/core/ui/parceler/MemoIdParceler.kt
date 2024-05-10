package app.kaito_dogi.mybrary.core.ui.parceler

import android.os.Parcel
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import kotlinx.parcelize.Parceler
import kotlinx.serialization.json.Json

object MemoIdParceler : Parceler<MemoId> {
  override fun create(parcel: Parcel): MemoId {
    val string = parcel.readString()!!
    return Json.decodeFromString(MemoId.serializer(), string)
  }

  override fun MemoId.write(
    parcel: Parcel,
    flags: Int,
  ) {
    val json = Json.encodeToString(MemoId.serializer(), this)
    parcel.writeString(json)
  }
}
