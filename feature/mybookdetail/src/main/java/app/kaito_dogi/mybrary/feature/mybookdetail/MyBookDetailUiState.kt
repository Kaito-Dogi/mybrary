package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.domain.model.MyBook

@Immutable
internal data class MyBookDetailUiState(
  val myBook: MyBook,
) {
  companion object {
    fun createInitialValue(myBook: MyBook): MyBookDetailUiState {
      return MyBookDetailUiState(myBook = myBook)
    }
  }
}
