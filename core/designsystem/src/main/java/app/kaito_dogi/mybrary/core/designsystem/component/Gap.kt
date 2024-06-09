package app.kaito_dogi.mybrary.core.designsystem.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun ColumnScope.Gap(
  height: Dp,
) {
  Spacer(modifier = Modifier.height(height = height))
}

@Composable
fun RowScope.Gap(
  width: Dp,
) {
  Spacer(modifier = Modifier.width(width = width))
}
