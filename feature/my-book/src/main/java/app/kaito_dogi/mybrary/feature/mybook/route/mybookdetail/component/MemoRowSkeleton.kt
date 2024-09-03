package app.kaito_dogi.mybrary.feature.mybook.route.mybookdetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
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
        start = MybraryTheme.spaces.sm,
        top = MybraryTheme.spaces.xs,
        end = MybraryTheme.spaces.sm,
        bottom = MybraryTheme.spaces.sm,
      ),
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.xxs),
    ) {
      Text(
        text = stringResource(id = R.string.my_book_detail_text_a),
        modifier = Modifier.fillMaxWidth(),
        color = Color.Transparent,
        style = MybraryTheme.typography.bodyLarge,
      )

      Text(
        text = stringResource(id = R.string.my_book_detail_text_a),
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
