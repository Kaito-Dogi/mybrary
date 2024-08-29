package app.kaito_dogi.mybrary.feature.searchbook.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.SkeletonBox
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R
import app.kaito_dogi.mybrary.core.ui.component.BookAspectRatio

@Composable
fun BookRowSkeleton(
  modifier: Modifier = Modifier,
) {
  SkeletonBox(
    shape = MybraryTheme.shapes.small,
    modifier = modifier,
  ) {
    Row(
      modifier = Modifier.height(IntrinsicSize.Min),
    ) {
      Box(
        modifier = Modifier
          .aspectRatio(BookAspectRatio)
          .width(MybraryTheme.dimens.bookWidthSm),
      )

      Column(
        verticalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.xxs),
      ) {
        Text(
          textResId = R.string.search_book_text_a_a,
          modifier = Modifier.fillMaxWidth(),
          color = Color.Transparent,
          style = MybraryTheme.typography.bodyLarge,
        )

        Text(
          textResId = R.string.search_book_text_a,
          modifier = Modifier.fillMaxWidth(),
          color = Color.Transparent,
          style = MybraryTheme.typography.bodySmall,
        )

        Text(
          textResId = R.string.search_book_text_a,
          modifier = Modifier.fillMaxWidth(),
          color = Color.Transparent,
          style = MybraryTheme.typography.bodySmall,
        )
      }
    }
  }
}

@Preview
@Composable
private fun BookRowSkeletonPreview() {
  MybraryTheme {
    BookRowSkeleton()
  }
}
