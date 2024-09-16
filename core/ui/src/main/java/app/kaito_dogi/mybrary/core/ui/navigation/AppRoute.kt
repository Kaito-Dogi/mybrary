package app.kaito_dogi.mybrary.core.ui.navigation

import kotlinx.serialization.Serializable

sealed interface AppRoute {
  @Serializable
  data object Auth : AppRoute

  @Serializable
  data object BookDetail : AppRoute

  @Serializable
  data object Main : AppRoute

  @Serializable
  data object SearchBook : AppRoute
}
