package app.kaito_dogi.mybrary.core.ui.navigation.route

import kotlinx.serialization.Serializable

sealed interface AppRoute {
  @Serializable
  data object Auth : AppRoute

  @Serializable
  data object Main : AppRoute
}
