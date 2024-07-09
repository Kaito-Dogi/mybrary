package app.kaito_dogi.mybrary.core.designsystem.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
fun RowScope.Line(
  modifier: Modifier = Modifier,
  color: Color = MybraryTheme.colorScheme.onBackground,
  strokeWidth: Dp = 1.dp,
) {
  Canvas(
    modifier = modifier.height(strokeWidth),
  ) {
    drawLine(
      color = color,
      start = Offset(
        x = 0f,
        y = size.height / 2,
      ),
      end = Offset(
        x = size.width,
        y = size.height / 2,
      ),
      strokeWidth = strokeWidth.value,
    )
  }
}

@Preview
@Composable
private fun LinePreview() {
  MybraryTheme {
    Row(
      modifier = Modifier
        .fillMaxSize()
        .background(MybraryTheme.colorScheme.background),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Line(modifier = Modifier.fillMaxWidth())
    }
  }
}
