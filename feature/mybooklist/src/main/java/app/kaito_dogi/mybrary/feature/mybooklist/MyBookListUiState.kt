package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.domain.model.MyBook

@Immutable
internal data class MyBookListUiState(
  val myBookList: List<MyBook>,
  val numberOfColumns: Int,
) {
  companion object {
    val initialValue = MyBookListUiState(
      myBookList = emptyList(),
      numberOfColumns = 3,
    )
  }
}
