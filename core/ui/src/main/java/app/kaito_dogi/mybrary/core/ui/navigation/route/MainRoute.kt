package app.kaito_dogi.mybrary.core.ui.navigation.route

import kotlinx.serialization.Serializable

sealed interface MainRoute {
  @Serializable
  data object MyBook : MainRoute

  @Serializable
  data object Setting : MainRoute
}
