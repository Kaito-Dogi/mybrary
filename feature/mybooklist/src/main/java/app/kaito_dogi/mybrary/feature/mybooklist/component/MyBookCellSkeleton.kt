package app.kaito_dogi.mybrary.feature.mybooklist.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.component.BookAspectRatio
import app.kaito_dogi.mybrary.core.ui.component.SkeletonBox


@Composable
internal fun MyBookCellSkeleton(
  modifier: Modifier = Modifier,
) {
  SkeletonBox(
    modifier = modifier
      .clip(shape = MybraryTheme.shapes.extraSmall)
      .aspectRatio(BookAspectRatio),
  ) {
    // 何も表示しない
  }
}

@Preview
@Composable
private fun MyBookCellSkeletonPreview() {
  MybraryTheme {
    MyBookCellSkeleton()
  }
}
