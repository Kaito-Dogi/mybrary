package app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.SkeletonBox
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.component.BookAspectRatio


@Composable
internal fun MyBookCellSkeleton(
  modifier: Modifier = Modifier,
) {
  SkeletonBox(
    shape = MybraryTheme.shapes.cornerSm,
    modifier = modifier.aspectRatio(BookAspectRatio),
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
