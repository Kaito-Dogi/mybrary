package app.kaito_dogi.mybrary.core.ui.navigation.route

import kotlinx.serialization.Serializable

sealed interface SettingRoute {
  @Serializable
  data object SettingList : SettingRoute
}
