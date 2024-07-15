package app.kaito_dogi.mybrary.feature.mybookdetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.SkeletonBox
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

@Composable
internal fun MemoRowSkeleton(
  modifier: Modifier = Modifier,
) {
  SkeletonBox(
    shape = MybraryTheme.shapes.small,
    modifier = modifier,
  ) {
    Column(
      modifier = modifier.padding(
        start = MybraryTheme.space.md,
        top = MybraryTheme.space.sm,
        end = MybraryTheme.space.md,
        bottom = MybraryTheme.space.md,
      ),
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.space.xxs),
    ) {
      Text(
        textResId = R.string.my_book_detail_text_a,
        modifier = Modifier.fillMaxWidth(),
        color = Color.Transparent,
        style = MybraryTheme.typography.bodyLarge,
      )

      Text(
        textResId = R.string.my_book_detail_text_a,
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
