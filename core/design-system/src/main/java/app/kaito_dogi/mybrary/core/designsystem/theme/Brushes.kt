package app.kaito_dogi.mybrary.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush

@Composable
@ReadOnlyComposable
internal fun backgroundBrush() = Brush.linearGradient(
  colors = listOf(
    MybraryTheme.colorScheme.surface,
    MybraryTheme.colorScheme.secondaryContainer,
    MybraryTheme.colorScheme.errorContainer,
  ),
  start = Offset(x = 0f, y = 0f),
  end = Offset(x = Float.POSITIVE_INFINITY, y = Float.POSITIVE_INFINITY),
)
