package app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.component.BookAspectRatio

@Composable
internal fun MyBookEmptyCell(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  ElevatedCard(
    onClick = onClick,
    modifier = modifier,
    shape = MybraryTheme.shapes.cornerSm,
  ) {
    Box(
      modifier = Modifier
        .aspectRatio(ratio = BookAspectRatio)
        .background(color = MybraryTheme.colorScheme.surface),
      contentAlignment = Alignment.Center,
    ) {
      Icon(
        painter = painterResource(id = R.drawable.icon_add),
        contentDescription = stringResource(id = R.string.my_book_list_alt_search_for_books),
        tint = MybraryTheme.colorScheme.onSurface,
      )
    }
  }
}

@Preview
@Composable
private fun MyBookEmptyCellPreview() {
  MybraryTheme {
    MyBookEmptyCell(
      onClick = {},
    )
  }
}
