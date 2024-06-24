package app.kaito_dogi.mybrary.feature.mybooklist.component

import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.ExternalBookId
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.model.User
import app.kaito_dogi.mybrary.core.domain.model.UserId
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
        id = MyBookId(value = 0L),
        bookId = BookId(value = 0L),
        externalId = ExternalBookId(value = "externalId"),
        user = User(
          id = UserId(value = 0L),
          name = "name",
        ),
        title = "title",
        imageUrl = Url.Image(value = "imageUrl"),
        isbn10 = "isbn10",
        isbn13 = "isbn13",
        pageCount = 0,
        authors = emptyList(),
        isPinned = false,
        isFavorite = false,
        isArchived = false,
      ),
      onClick = {},
    )
  }
}
