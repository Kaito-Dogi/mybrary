package app.kaito_dogi.mybrary.feature.mybookdetail

import android.os.Parcelable
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MemoId
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.ui.parceler.MemoIdParceler
import app.kaito_dogi.mybrary.core.ui.parceler.MemoParceler
import app.kaito_dogi.mybrary.core.ui.parceler.MyBookIdParceler
import app.kaito_dogi.mybrary.core.ui.parceler.MyBookParceler
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.TypeParceler
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
@TypeParceler<MyBook, MyBookParceler>
@TypeParceler<MyBookId, MyBookIdParceler>
@TypeParceler<Memo, MemoParceler>
@TypeParceler<MemoId, MemoIdParceler>
data class MyBookDetailNavArg(
  val myBook: MyBook,
) : Parcelable
