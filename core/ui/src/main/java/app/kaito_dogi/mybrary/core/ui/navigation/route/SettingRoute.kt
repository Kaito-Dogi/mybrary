package app.kaito_dogi.mybrary.core.ui.navigation.route

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface SettingRoute : NavKey {
  @Serializable
  data object SettingList : SettingRoute
}
