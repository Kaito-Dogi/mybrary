package app.kaito_dogi.mybrary.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun Icon(
  @DrawableRes iconResId: Int,
  @StringRes altResId: Int?,
  modifier: Modifier = Modifier,
  tint: Color = LocalContentColor.current,
) = androidx.compose.material3.Icon(
  painter = painterResource(id = iconResId),
  contentDescription = altResId?.let { stringResource(id = it) },
  modifier = modifier,
  tint = tint,
)
