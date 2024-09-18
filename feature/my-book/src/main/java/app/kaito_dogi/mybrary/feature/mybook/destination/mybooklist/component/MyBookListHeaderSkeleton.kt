package app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
internal fun MyBookListHeaderSkeleton(
  modifier: Modifier = Modifier,
) {
  SkeletonBox(
    shape = MybraryTheme.shapes.extraSmall,
    modifier = modifier
      .fillMaxWidth()
      .height(MybraryTheme.dimens.topAppBarHeight - MybraryTheme.spaces.sm * 2),
  ) {
    Text(
      text = stringResource(id = R.string.my_book_list_text_a),
      color = Color.Transparent,
      style = MybraryTheme.typography.titleLarge,
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
