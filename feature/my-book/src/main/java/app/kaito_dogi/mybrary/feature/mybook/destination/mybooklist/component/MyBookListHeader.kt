package app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

@Composable
internal fun MyBookListHeader(
  @StringRes titleResId: Int,
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = modifier.fillMaxWidth(),
  ) {
    Text(
      text = stringResource(id = titleResId),
      color = MybraryTheme.colorScheme.onBackground,
      style = MybraryTheme.typography.headlineSmall,
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
