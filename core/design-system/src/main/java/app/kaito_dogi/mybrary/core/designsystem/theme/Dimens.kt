package app.kaito_dogi.mybrary.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Dimens(
  val bookWidthSm: Dp,
  val bookWidthMd: Dp,
  val navigationBarHeight: Dp,
)

private val defaultDimens = Dimens(
  bookWidthSm = 96.dp,
  bookWidthMd = 120.dp,
  navigationBarHeight = 80.dp,
)

internal val LocalDimens = staticCompositionLocalOf { defaultDimens }
