package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.domain.model.MyBook

internal sealed interface MyBookListUiState {
  val numberOfColumns: Int

  @Immutable
  data class Loading(
    override val numberOfColumns: Int,
  ) : MyBookListUiState

  @Immutable
  data class Success(
    override val numberOfColumns: Int,
    val myBookList: List<MyBook>,
  ) : MyBookListUiState
}
