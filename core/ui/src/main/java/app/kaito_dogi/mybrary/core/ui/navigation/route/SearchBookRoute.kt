package app.kaito_dogi.mybrary.core.ui.navigation.route

import app.kaito_dogi.mybrary.core.domain.model.Book
import kotlinx.serialization.Serializable

sealed interface SearchBookRoute {
  @Serializable
  data object SearchBook : SearchBookRoute

  @Serializable
  data object ScanBarcode : SearchBookRoute

  @Serializable
  data class BookDetail(
    val book: Book,
  ) : SearchBookRoute
}
