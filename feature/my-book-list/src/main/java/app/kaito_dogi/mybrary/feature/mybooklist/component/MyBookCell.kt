package app.kaito_dogi.mybrary.feature.mybooklist.component

import androidx.compose.material3.ElevatedCard
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

@Composable
internal fun MyBookCell(
  myBook: MyBook,
  onClick: (MyBook) -> Unit,
  modifier: Modifier = Modifier,
) {
  ElevatedCard(
    onClick = { onClick(myBook) },
    modifier = modifier,
    shape = MybraryTheme.shapes.extraSmall,
  ) {
    BookImage(imageUrl = myBook.imageUrl)
  }
}

@Preview
@Composable
private fun MyBookCellPreview() {
  MybraryTheme {
    MyBookCell(
      myBook = MyBook(
        id = MyBookId(value = 0L),
        user = User(
          id = UserId(value = "userId"),
          name = "ユーザー名",
        ),
        bookId = BookId(value = 0L),
        externalId = ExternalBookId(value = "externalId"),
        title = "タイトル",
        imageUrl = Url.Image(value = "imageUrl"),
        isbn10 = "isbn10",
        isbn13 = "isbn13",
        pageCount = Int.MAX_VALUE,
        publisher = "出版社",
        authors = emptyList(),
        isPinned = false,
        isFavorite = false,
        isPublic = false,
        isArchived = false,
      ),
      onClick = {},
    )
  }
}
