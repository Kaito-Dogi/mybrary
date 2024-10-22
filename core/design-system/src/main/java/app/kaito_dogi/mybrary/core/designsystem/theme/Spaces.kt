package app.kaito_dogi.mybrary.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Spaces(
  val xxxs: Dp,
  val xxs: Dp,
  val xs: Dp,
  val sm: Dp,
  val md: Dp,
  val lg: Dp,
  val xl: Dp,
  val xxl: Dp,
  val xxxl: Dp,
)

private val defaultSpaces = Spaces(
  xxxs = 2.dp,
  xxs = 4.dp,
  xs = 8.dp,
  sm = 12.dp,
  md = 16.dp,
  lg = 20.dp,
  xl = 24.dp,
  xxl = 32.dp,
  xxxl = 64.dp,
)

internal val LocalSpaces = staticCompositionLocalOf { defaultSpaces }
