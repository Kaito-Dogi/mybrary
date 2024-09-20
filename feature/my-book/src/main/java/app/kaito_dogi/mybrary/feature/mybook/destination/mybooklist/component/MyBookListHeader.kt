package app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

@Composable
internal fun MyBookListHeader(
  @StringRes titleResId: Int,
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = modifier
      .fillMaxWidth()
      .height(MybraryTheme.dimens.topAppBarHeight - MybraryTheme.spaces.sm * 2),
    contentAlignment = Alignment.CenterStart,
  ) {
    Text(
      text = stringResource(id = titleResId),
      color = MybraryTheme.colorScheme.onBackground,
      style = MybraryTheme.typography.titleLarge,
    )
  }
}

@Preview(showBackground = true)
@Composable
private fun MyBookListHeaderPreview() {
  MybraryTheme {
    MyBookListHeader(
      titleResId = R.string.my_book_list_text_all_my_books,
    )
  }
}
