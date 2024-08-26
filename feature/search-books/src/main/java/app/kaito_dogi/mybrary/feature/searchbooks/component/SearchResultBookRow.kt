package app.kaito_dogi.mybrary.feature.searchbooks.component

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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.ExternalBookId
import app.kaito_dogi.mybrary.core.ui.R
import app.kaito_dogi.mybrary.core.ui.component.BookImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun SearchResultBookRow(
  searchResultBook: SearchedBook,
  onClick: (SearchedBook) -> Unit,
  onLongClick: (SearchedBook) -> Unit,
  modifier: Modifier = Modifier,
) {
  Card(
    modifier = modifier
      .fillMaxWidth()
      .combinedClickable(
        onClick = { onClick(searchResultBook) },
        onLongClick = { onLongClick(searchResultBook) },
      ),
    shape = MybraryTheme.shapes.small,
  ) {
    Row(
      modifier = Modifier
        .padding(MybraryTheme.space.md)
        .height(IntrinsicSize.Min),
      horizontalArrangement = Arrangement.spacedBy(MybraryTheme.space.sm),
    ) {
      // TODO: 定数にする
      BookImage(
        imageUrl = searchResultBook.imageUrl,
        modifier = Modifier.width(72.dp),
      )

      Column(
        verticalArrangement = Arrangement.spacedBy(MybraryTheme.space.xxs),
      ) {
        Text(
          text = searchResultBook.title,
          modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
          overflow = TextOverflow.Ellipsis,
          maxLines = 2,
          style = MybraryTheme.typography.titleMedium,
        )

        if (searchResultBook.authors.isNotEmpty()) {
          Text(
            text = searchResultBook.authors.joinToString { it.name },
            modifier = Modifier.fillMaxWidth(),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = MybraryTheme.typography.bodyMedium,
          )
        }

        val context = LocalContext.current
        val rowBody = remember(searchResultBook, context) {
          when {
            searchResultBook.pageCount != null && searchResultBook.publisher != null -> context.getString(
              R.string.search_books_text_page_count_and_publisher,
              searchResultBook.pageCount,
              searchResultBook.publisher,
            )

            searchResultBook.pageCount != null -> context.getString(
              R.string.search_books_text_page_count,
              searchResultBook.pageCount,
            )

            searchResultBook.publisher != null -> "${searchResultBook.publisher}"

            else -> ""
          }
        }

        if (rowBody.isNotBlank()) {
          Text(
            text = rowBody,
            modifier = Modifier.fillMaxWidth(),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = MybraryTheme.typography.bodyMedium,
          )
        }
      }
    }
  }
}

@Preview
@Composable
private fun SearchResultBookRowPreview() {
  MybraryTheme {
    SearchResultBookRow(
      searchResultBook = SearchedBook(
        externalId = ExternalBookId(value = "externalId"),
        title = "タイトル\nタイトル\nタイトル",
        imageUrl = Url.Image(value = "imageUrl"),
        isbn10 = "isbn10",
        isbn13 = "isbn13",
        pageCount = Int.MAX_VALUE,
        publisher = "出版社",
        authors = listOf(SearchResultAuthor(name = "著者名")),
      ),
      onClick = {},
      onLongClick = {},
    )
  }
}
