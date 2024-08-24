package app.kaito_dogi.mybrary.feature.mybook

import app.kaito_dogi.mybrary.core.domain.model.MyBook
import kotlinx.serialization.Serializable

sealed interface MyBookRoute {
  @Serializable
  data object MyBookList : MyBookRoute

  @Serializable
  data class MyBookDetail(
    val myBook: MyBook,
  ) : MyBookRoute
}
