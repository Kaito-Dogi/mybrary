package app.kaito_dogi.mybrary.feature.searchbook.component

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.component.Gap
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.ExternalBookId
import app.kaito_dogi.mybrary.core.domain.model.SearchResultAuthor
import app.kaito_dogi.mybrary.core.domain.model.SearchResultBook
import app.kaito_dogi.mybrary.core.ui.component.BookImage

// TODO: 長押ししたときの処理も受け取る
@Composable
internal fun SearchResultBookRow(
  searchResultBook: SearchResultBook,
  onClick: (SearchResultBook) -> Unit,
  modifier: Modifier = Modifier,
) {
  Card(
    onClick = { onClick(searchResultBook) },
    modifier = modifier.fillMaxWidth(),
    shape = MybraryTheme.shapes.small,
  ) {
    Row(
      modifier = Modifier
        .padding(MybraryTheme.space.md)
        .height(IntrinsicSize.Min)
        .fillMaxWidth(),
    ) {
      BookImage(
        imageUrl = searchResultBook.imageUrl,
        title = searchResultBook.title,
        modifier = Modifier
          .width(72.dp) // TODO: 定数にする
          .clip(shape = MybraryTheme.shapes.extraSmall),
      )
      Gap(width = MybraryTheme.space.md)
      Column(
        verticalArrangement = Arrangement.spacedBy(MybraryTheme.space.xxs),
      ) {
        Text(
          text = searchResultBook.title,
          modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
          style = MybraryTheme.typography.titleMedium,
          maxLines = 2,
        )
        if (searchResultBook.authors.isNotEmpty()) {
          Text(
            text = searchResultBook.authors.joinToString { it.name },
            modifier = Modifier.fillMaxWidth(),
            style = MybraryTheme.typography.bodyMedium,
            maxLines = 1,
          )
        }
        if (searchResultBook.rowBody.isNotBlank()) {
          Text(
            text = searchResultBook.rowBody,
            style = MybraryTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
          )
        }
      }
    }
  }
}

private val SearchResultBook.rowBody
  get() = run {
    val page = if (this.pageCount > 0) "${this.pageCount}ページ" else ""
    when {
      page.isNotBlank() && this.publisher.isNotBlank() -> "$page｜${this.publisher}"
      page.isNotBlank() && this.publisher.isBlank() -> page
      page.isBlank() && this.publisher.isNotBlank() -> this.publisher
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
    )
  }
}
