package app.kaito_dogi.mybrary.feature.mybook

import kotlinx.serialization.Serializable

sealed interface MyBookRoute {
  @Serializable
  data object MyBookList : MyBookRoute

  @Serializable
  data object MyBookDetail: MyBookRoute
}
