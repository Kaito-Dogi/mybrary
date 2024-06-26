package app.kaito_dogi.mybrary.feature.mybookdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.component.Gap
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.Author
import app.kaito_dogi.mybrary.core.domain.model.AuthorId
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.ExternalBookId
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.model.User
import app.kaito_dogi.mybrary.core.domain.model.UserId
import app.kaito_dogi.mybrary.core.ui.component.BookImage
import coil.compose.AsyncImage

private const val Contrast = 0.8f // コントラスト
private const val Brightness = -60f // 明度
private val ColorMatrix = floatArrayOf(
  Contrast, 0f, 0f, 0f, Brightness,
  0f, Contrast, 0f, 0f, Brightness,
  0f, 0f, Contrast, 0f, Brightness,
  0f, 0f, 0f, 1f, 0f,
)

@Composable
internal fun MyBookDetailTopAppBar(
  myBook: MyBook,
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = modifier
      .fillMaxWidth()
      .height(IntrinsicSize.Min),
  ) {
    AsyncImage(
      model = myBook.imageUrl.value,
      modifier = Modifier
        .fillMaxHeight()
        .background(MybraryTheme.colorScheme.primary)
        .blur(
          radiusX = MybraryTheme.space.md,
          radiusY = MybraryTheme.space.md,
        ),
      contentDescription = "背景画像",
      contentScale = ContentScale.FillWidth,
      colorFilter = ColorFilter.colorMatrix(ColorMatrix(ColorMatrix)),
    )
    Column(
      modifier = modifier.padding(MybraryTheme.space.md),
    ) {
      Gap(height = WindowInsets.systemBars.asPaddingValues().calculateTopPadding())
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .height(IntrinsicSize.Min),
      ) {
        BookImage(
          imageUrl = myBook.imageUrl,
          title = myBook.title,
          modifier = Modifier
            .width(120.dp) // TODO: 定数にする
            .clip(shape = MybraryTheme.shapes.extraSmall),
        )
        Gap(width = MybraryTheme.space.md)
        Column(
          modifier = Modifier
            .fillMaxHeight()
            .weight(1f),
          verticalArrangement = Arrangement.spacedBy(MybraryTheme.space.xs),
        ) {
          Text(
            text = myBook.title,
            modifier = Modifier.weight(1f),
            color = MybraryTheme.colorScheme.onPrimary,
            style = MybraryTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis,
            maxLines = 4,
          )
          if (myBook.authors.isNotEmpty()) {
            Text(
              text = myBook.authors.joinToString { it.name },
              color = MybraryTheme.colorScheme.onPrimary,
              style = MybraryTheme.typography.bodyMedium,
              overflow = TextOverflow.Ellipsis,
              maxLines = 2,
            )
          }
          if (myBook.topAppBarBody.isNotBlank()) {
            Text(
              text = myBook.topAppBarBody,
              color = MybraryTheme.colorScheme.onPrimary,
              style = MybraryTheme.typography.bodyMedium,
              overflow = TextOverflow.Ellipsis,
              maxLines = 1,
            )
          }
        }
      }
    }
  }
}

private val MyBook.topAppBarBody
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
private fun MyBookDetailTopAppBarPreview() {
  MybraryTheme {
    MyBookDetailTopAppBar(
      myBook = MyBook(
        id = MyBookId(value = 0L),
        bookId = BookId(value = 0L),
        externalId = ExternalBookId(value = "externalId"),
        user = User(
          id = UserId(value = 0L),
          name = "ユーザー名",
        ),
        title = "タイトル\nタイトル\nタイトル\nタイトル\nタイトル",
        imageUrl = Url.Image(value = "imageUrl"),
        isbn10 = "isbn10",
        isbn13 = "isbn13",
        pageCount = Int.MAX_VALUE,
        publisher = "出版社",
        authors = List(10) {
          Author(
            id = AuthorId(value = 0L),
            name = "著者$it",
          )
        },
        isPinned = false,
        isFavorite = false,
        isPublic = false,
        isArchived = false,
      ),
    )
  }
}
