package app.kaito_dogi.mybrary.core.designsystem.ext

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PaddingValues.plus(
  all: Dp = 0.dp,
): PaddingValues {
  val layoutDirection = LocalLayoutDirection.current
  return PaddingValues(
    start = this.calculateStartPadding(layoutDirection) + all,
    top = this.calculateTopPadding() + all,
    end = this.calculateEndPadding(layoutDirection) + all,
    bottom = this.calculateBottomPadding() + all,
  )
}

@Composable
fun PaddingValues.plus(
  horizontal: Dp = 0.dp,
  vertical: Dp = 0.dp,
): PaddingValues {
  val layoutDirection = LocalLayoutDirection.current
  return PaddingValues(
    start = this.calculateStartPadding(layoutDirection) + horizontal,
    top = this.calculateTopPadding() + vertical,
    end = this.calculateEndPadding(layoutDirection) + horizontal,
    bottom = this.calculateBottomPadding() + vertical,
  )
}

@Composable
fun PaddingValues.plus(
  start: Dp = 0.dp,
  top: Dp = 0.dp,
  end: Dp = 0.dp,
  bottom: Dp = 0.dp,
): PaddingValues {
  val layoutDirection = LocalLayoutDirection.current
  return PaddingValues(
    start = this.calculateStartPadding(layoutDirection) + start,
    top = this.calculateTopPadding() + top,
    end = this.calculateEndPadding(layoutDirection) + end,
    bottom = this.calculateBottomPadding() + bottom,
  )
}
