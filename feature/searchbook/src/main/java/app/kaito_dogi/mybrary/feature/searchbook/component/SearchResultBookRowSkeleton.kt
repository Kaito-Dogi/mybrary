package app.kaito_dogi.mybrary.feature.searchbook.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.component.BookAspectRatio
import app.kaito_dogi.mybrary.core.ui.component.SkeletonBox

@Composable
fun SearchResultBookRowSkeleton(
  modifier: Modifier = Modifier,
) {
  SkeletonBox(
    shape = MybraryTheme.shapes.small,
    modifier = modifier,
  ) {
    Row(
      modifier = Modifier
        .padding(MybraryTheme.space.md)
        .height(IntrinsicSize.Min),
    ) {
      // TODO: width を定数化する
      Box(
        modifier = Modifier
          .aspectRatio(BookAspectRatio)
          .width(72.dp),
      )
      Column(verticalArrangement = Arrangement.spacedBy(MybraryTheme.space.xxs)) {
        Text(
          text = "あ\nあ",
          modifier = Modifier.fillMaxWidth(),
          color = Color.Transparent,
          style = MybraryTheme.typography.titleMedium,
        )
        Text(
          text = "あ",
          modifier = Modifier.fillMaxWidth(),
          color = Color.Transparent,
          style = MybraryTheme.typography.bodyMedium,
        )
        Text(
          text = "あ",
          modifier = Modifier.fillMaxWidth(),
          color = Color.Transparent,
          style = MybraryTheme.typography.bodyMedium,
        )
      }
    }
  }
}

@Preview
@Composable
private fun SearchResultBookRowSkeletonPreview() {
  MybraryTheme {
    SearchResultBookRowSkeleton()
  }
}
