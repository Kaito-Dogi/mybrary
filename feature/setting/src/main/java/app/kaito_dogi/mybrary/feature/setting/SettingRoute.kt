package app.kaito_dogi.mybrary.feature.setting

import kotlinx.serialization.Serializable

sealed interface SettingRoute {
  @Serializable
  data object SettingList : SettingRoute
}
