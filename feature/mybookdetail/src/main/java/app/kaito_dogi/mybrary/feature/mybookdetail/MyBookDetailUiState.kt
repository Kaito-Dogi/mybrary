package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MyBook

internal sealed interface MyBookDetailUiState {
  val myBook: MyBook

  @Immutable
  data class Loading(
    override val myBook: MyBook,
  ) : MyBookDetailUiState

  @Immutable
  data class Success(
    override val myBook: MyBook,
    val memos: List<Memo>,
  ) : MyBookDetailUiState
}
