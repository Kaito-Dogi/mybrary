package app.kaito_dogi.mybrary.feature.mybooklist.component

import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.ui.component.BookImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MyBookCard(
  myBook: MyBook,
  onClick: (MyBook) -> Unit,
  modifier: Modifier = Modifier,
) {
  ElevatedCard(
    onClick = { onClick(myBook) },
    modifier = modifier,
    shape = MybraryTheme.shapes.extraSmall,
  ) {
    BookImage(
      imageUrl = myBook.imageUrl,
      title = myBook.title,
    )
  }
}

@Preview
@Composable
private fun MyBookCardPreview() {
  MybraryTheme {
    MyBookCard(
      myBook = MyBook(
        id = MyBookId(0L),
        externalId = "externalId",
        title = "title",
        authors = "authors",
        imageUrl = Url.Image(value = "imageUrl"),
        isPinned = false,
        isFavorite = false,
        isArchived = false,
        memos = emptyList(),
      ),
      onClick = {},
    )
  }
}
