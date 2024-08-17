package app.kaito_dogi.mybrary.feature.mybook.route.mybooklist.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.SkeletonBox
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

@Composable
internal fun MyBookListHeaderSkeleton(
  modifier: Modifier = Modifier,
) {
  SkeletonBox(
    shape = MybraryTheme.shapes.extraSmall,
    modifier = modifier,
  ) {
    Text(
      textResId = R.string.my_book_list_text_a,
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
