package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.domain.model.MyBook

private const val NumberOfColumns = 3

@Immutable
internal data class MyBookListUiState(
  val numberOfColumns: Int,
  val myBookList: List<MyBook>?,
) {
  val favoriteMyBookList: List<MyBook>? = myBookList?.filter { it.isFavorite }
  val otherMyBookList: List<MyBook>? = myBookList?.filterNot { it.isFavorite }
  val areAllMyBooksInOtherList: Boolean = otherMyBookList == myBookList

  companion object {
    val InitialValue = MyBookListUiState(
      numberOfColumns = NumberOfColumns,
      myBookList = null,
    )
  }
}
