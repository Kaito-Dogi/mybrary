package app.kaito_dogi.mybrary.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal val mybraryDimens = Dimens(
  bookWidthSm = 96.dp,
  bookWidthMd = 120.dp,
  navigationBarHeight = 80.dp,
)

@Immutable
data class Dimens(
  val bookWidthSm: Dp,
  val bookWidthMd: Dp,
  val navigationBarHeight: Dp,
)

private val defaultDimens = Dimens(
  bookWidthSm = Dp.Hairline,
  bookWidthMd = Dp.Hairline,
  navigationBarHeight = Dp.Hairline,
)

internal val LocalDimens = staticCompositionLocalOf { defaultDimens }
