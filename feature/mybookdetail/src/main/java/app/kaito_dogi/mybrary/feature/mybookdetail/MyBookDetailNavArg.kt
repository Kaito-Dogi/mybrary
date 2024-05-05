package app.kaito_dogi.mybrary.feature.mybookdetail

import android.os.Parcelable
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.ui.MyBookIdParceler
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.TypeParceler
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
@TypeParceler<MyBookId, MyBookIdParceler>
data class MyBookDetailNavArg(
  val myBookId: MyBookId,
) : Parcelable
