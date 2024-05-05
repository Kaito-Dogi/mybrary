package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.domain.model.MyBookId

@Immutable
internal data class MyBookDetailUiState(
//  val myBook: MyBook,
  val myBookId: MyBookId,
) {
  companion object {
    //    fun createInitialValue(myBook: MyBook): MyBookDetailUiState {
//      return MyBookDetailUiState(myBook = myBook)
//    }
    fun createInitialValue(myBookId: MyBookId): MyBookDetailUiState {
      return MyBookDetailUiState(myBookId = myBookId)
    }
  }
}
