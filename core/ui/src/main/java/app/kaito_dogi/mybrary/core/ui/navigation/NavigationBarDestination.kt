package app.kaito_dogi.mybrary.core.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import app.kaito_dogi.mybrary.core.designsystem.R


internal enum class NavigationBarDestination(
  private val typeSafeRoute: MainRoute,
  @DrawableRes val iconResId: Int,
  @StringRes val iconAltResId: Int,
  @StringRes val labelResId: Int,
) {
  MyBook(
    typeSafeRoute = MainRoute.MyBook,
    iconResId = R.drawable.icon_book,
    iconAltResId = R.string.ui_alt_my_book,
    labelResId = R.string.ui_text_my_book,
  ),
  Setting(
    typeSafeRoute = MainRoute.Setting,
    iconResId = R.drawable.icon_settings,
    iconAltResId = R.string.ui_alt_setting,
    labelResId = R.string.ui_text_setting,
  ),
  ;
  val route = typeSafeRoute::class.qualifiedName
}
