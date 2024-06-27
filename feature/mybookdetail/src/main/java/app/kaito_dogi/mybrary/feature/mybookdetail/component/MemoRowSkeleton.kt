package app.kaito_dogi.mybrary.feature.mybookdetail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Gap
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.component.SkeletonBox

@Composable
internal fun MemoRowSkeleton(
  modifier: Modifier = Modifier,
) {
  SkeletonBox(
    modifier = modifier
      .clip(shape = MybraryTheme.shapes.small)
      .fillMaxWidth(),
  ) {
    Column(
      modifier = modifier.padding(
        start = MybraryTheme.space.md,
        top = MybraryTheme.space.sm,
        end = MybraryTheme.space.md,
        bottom = MybraryTheme.space.md,
      ),
    ) {
      Text(
        text = "あ",
        modifier = Modifier.fillMaxWidth(),
        color = Color.Transparent,
        style = MybraryTheme.typography.bodyLarge,
      )
      Gap(height = MybraryTheme.space.xxs)
      Text(
        text = "あ",
        modifier = Modifier.fillMaxWidth(),
        color = Color.Transparent,
        style = MybraryTheme.typography.bodySmall,
      )
    }
  }
}

@Preview
@Composable
private fun MemoRowSkeletonPreview() {
  MybraryTheme {
    MemoRowSkeleton()
  }
}
