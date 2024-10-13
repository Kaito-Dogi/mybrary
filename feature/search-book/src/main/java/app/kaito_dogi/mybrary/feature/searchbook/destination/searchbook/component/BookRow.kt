package app.kaito_dogi.mybrary.feature.searchbook.destination.searchbook.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.Author
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.Genre
import app.kaito_dogi.mybrary.core.ui.component.BookImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun BookRow(
  book: Book,
  onClick: (Book) -> Unit,
  onLongClick: (Book) -> Unit,
  modifier: Modifier = Modifier,
) {
  Card(
    modifier = modifier
      .fillMaxWidth()
      .combinedClickable(
        onClick = { onClick(book) },
        onLongClick = { onLongClick(book) },
      ),
    shape = MybraryTheme.shapes.small,
  ) {
    Row(
      modifier = Modifier.height(IntrinsicSize.Min),
      horizontalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.sm),
    ) {
      BookImage(
        title = book.title,
        imageUrl = book.imageUrl,
        modifier = Modifier.width(MybraryTheme.dimens.bookWidthSm),
        shape = RectangleShape,
      )

      Column(
        modifier = Modifier.padding(
          top = MybraryTheme.spaces.xs,
          end = MybraryTheme.spaces.xs,
          bottom = MybraryTheme.spaces.xs,
        ),
        verticalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.xxs),
      ) {
        Text(
          text = book.title,
          modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
          overflow = TextOverflow.Ellipsis,
          maxLines = 3,
          style = MybraryTheme.typography.bodyLarge,
        )

        if (book.authorList.isNotEmpty()) {
          Text(
            text = book.authorList.joinToString { it.name },
            modifier = Modifier.fillMaxWidth(),
            color = MybraryTheme.colorScheme.onSurfaceVariant,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = MybraryTheme.typography.bodySmall,
          )
        }

        Text(
          text = book.publisher,
          modifier = Modifier.fillMaxWidth(),
          color = MybraryTheme.colorScheme.onSurfaceVariant,
          overflow = TextOverflow.Ellipsis,
          maxLines = 1,
          style = MybraryTheme.typography.bodySmall,
        )
      }
    }
  }
}

@Preview
@Composable
private fun BookRowPreview() {
  MybraryTheme {
    BookRow(
      book = Book(
        id = BookId(value = ""),
        title = "タイトルタイトルタイトルタイトルタイトル\nタイトル\nタイトル",
        imageUrl = Url.Image(value = "imageUrl"),
        isbn = "isbn",
        publisher = "出版社",
        authorList = listOf(
          Author(name = "著者名"),
        ),
        genre = Genre.All,
        rakutenUrl = Url.Affiliate(value = ""),
        amazonUrl = null,
      ),
      onClick = {},
      onLongClick = {},
    )
  }
}
