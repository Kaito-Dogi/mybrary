package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.domain.model.MyBook

private const val NUMBER_OF_COLUMNS = 3

@Immutable
internal data class MyBookListUiState(
  val numberOfColumns: Int,
  val myBookList: List<MyBook>?,
) {
  companion object {
    val InitialValue = MyBookListUiState(
      numberOfColumns = NUMBER_OF_COLUMNS,
      myBookList = null,
    )
  }
}
