package app.kaito_dogi.mybrary.core.designsystem.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

internal val mybraryShapes = Shapes(
  rectangle = RectangleShape,
  circle = CircleShape,
  cornerSm = RoundedCornerShape(4.0.dp),
  cornerMd = RoundedCornerShape(8.0.dp),
)

@Immutable
data class Shapes(
  val rectangle: Shape,
  val circle: Shape,
  val cornerSm: Shape,
  val cornerMd: Shape,
)

private val defaultShapes = Shapes(
  rectangle = RectangleShape,
  circle = CircleShape,
  cornerSm = RoundedCornerShape(4.0.dp),
  cornerMd = RoundedCornerShape(8.0.dp),
)

internal val LocalShapes = staticCompositionLocalOf { defaultShapes }
