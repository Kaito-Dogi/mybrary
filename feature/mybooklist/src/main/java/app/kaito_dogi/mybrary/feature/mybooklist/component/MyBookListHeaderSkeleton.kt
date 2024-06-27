package app.kaito_dogi.mybrary.feature.mybooklist.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.SkeletonBox
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
internal fun MyBookListHeaderSkeleton(
  modifier: Modifier = Modifier,
) {
  SkeletonBox(
    shape = MybraryTheme.shapes.extraSmall,
    modifier = modifier,
  ) {
    Text(
      text = "あ",
      modifier = Modifier.fillMaxWidth(),
      color = Color.Transparent,
      style = MybraryTheme.typography.headlineMedium,
    )
  }
}

@Preview
@Composable
private fun MyBookListHeaderSkeletonPreview() {
  MybraryTheme {
    MyBookListHeaderSkeleton()
  }
}
