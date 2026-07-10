package app.kaito_dogi.mybrary.core.ui.navigation.route

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface SearchBookRoute : NavKey {
  @Serializable
  data object SearchBook : SearchBookRoute
}
