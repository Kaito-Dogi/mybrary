package app.kaito_dogi.mybrary.core.designsystem.ext

import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun FloatingActionButtonDefaults.elevationZero() = this.elevation(
  defaultElevation = 0.dp,
  pressedElevation = 0.dp,
  focusedElevation = 0.dp,
  hoveredElevation = 0.dp,
)
