package app.kaito_dogi.mybrary.core.ui.navigation.route

import kotlinx.serialization.Serializable

sealed interface MybraryRoute {
  @Serializable
  data object Auth : MybraryRoute

  @Serializable
  data object Main : MybraryRoute
}
