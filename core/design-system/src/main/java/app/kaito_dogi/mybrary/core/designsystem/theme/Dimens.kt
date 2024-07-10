package app.kaito_dogi.mybrary.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


internal val mybraryDimens = Dimens(
  floatingActionButtonSize = 56.dp,
  topAppBarHeight = 64.dp,
)

@Immutable
data class Dimens(
  val floatingActionButtonSize: Dp,
  val topAppBarHeight: Dp,
)

private val defaultDimens = Dimens(
  floatingActionButtonSize = Dp.Hairline,
  topAppBarHeight = Dp.Hairline,
)

internal val LocalDimens = staticCompositionLocalOf { defaultDimens }
