package app.kaito_dogi.mybrary.core.navigation

import kotlinx.serialization.Serializable

sealed interface MybraryRoute {
  @Serializable
  data object Auth : MybraryRoute
}
