package app.kaito_dogi.mybrary.core.ui.navigation.route

import androidx.navigation3.runtime.NavKey
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import kotlinx.serialization.Serializable

sealed interface MyBookRoute : NavKey {
  @Serializable
  data object MyBookList : MyBookRoute

  @Serializable
  data class MyBookDetail(
    val myBook: MyBook,
  ) : MyBookRoute
}
