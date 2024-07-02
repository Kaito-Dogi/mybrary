package app.kaito_dogi.mybrary.feature.searchbook.component

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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.designsystem.component.Gap
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.ExternalBookId
import app.kaito_dogi.mybrary.core.domain.model.SearchResultAuthor
import app.kaito_dogi.mybrary.core.domain.model.SearchResultBook
import app.kaito_dogi.mybrary.core.domain.model.Url
import app.kaito_dogi.mybrary.core.ui.component.BookImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun SearchResultBookRow(
  searchResultBook: SearchResultBook,
  onClick: (SearchResultBook) -> Unit,
  onLongClick: (SearchResultBook) -> Unit,
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
    ) {
      // TODO: 定数にする
      BookImage(
        imageUrl = searchResultBook.imageUrl,
        title = searchResultBook.title,
        modifier = Modifier.width(72.dp),
      )
      Gap(width = MybraryTheme.space.sm)
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
        if (searchResultBook.rowBody.isNotBlank()) {
          Text(
            text = searchResultBook.rowBody,
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

private val SearchResultBook.rowBody: String
  get() = run {
    when {
      this.pageCount != null && this.publisher != null -> "${this.pageCount}ページ｜${this.publisher}"
      this.pageCount != null -> "${this.pageCount}ページ"
      this.publisher != null -> "${this.publisher}"
      else -> ""
    }
  }

@Preview
@Composable
private fun SearchResultBookRowPreview() {
  MybraryTheme {
    SearchResultBookRow(
      searchResultBook = SearchResultBook(
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
