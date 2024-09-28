package app.kaito_dogi.mybrary.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun RowScope.NavigationBarItem(
  isSelected: Boolean,
  onClick: () -> Unit,
  @DrawableRes iconResId: Int,
  @StringRes iconAltResId: Int,
  modifier: Modifier = Modifier,
  @StringRes labelResId: Int? = null,
) = NavigationBarItem(
  selected = isSelected,
  onClick = onClick,
  icon = {
    Icon(
      iconResId = iconResId,
      altResId = iconAltResId,
    )
  },
  modifier = modifier,
  label = labelResId?.let {
    {
      Text(text = stringResource(id = labelResId))
    }
  },
)
