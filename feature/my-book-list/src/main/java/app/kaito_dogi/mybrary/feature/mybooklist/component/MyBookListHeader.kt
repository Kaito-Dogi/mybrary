package app.kaito_dogi.mybrary.feature.mybooklist.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

@Composable
internal fun MyBookListHeader(
  @StringRes titleResId: Int,
  modifier: Modifier = Modifier,
) {
  Text(
    textResId = titleResId,
    modifier = modifier.fillMaxWidth(),
    color = MybraryTheme.colorScheme.onBackground,
    style = MybraryTheme.typography.headlineMedium,
  )
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
