package app.kaito_dogi.mybrary.feature.mybookdetail.component

import androidx.compose.foundation.background
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
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.ExternalBookId
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.model.User
import app.kaito_dogi.mybrary.core.domain.model.UserId
import app.kaito_dogi.mybrary.core.ui.component.BookImage
import coil.compose.AsyncImage

private const val contrast = 0.8f // コントラスト
private const val brightness = -60f // 明度
private val colorMatrix = floatArrayOf(
  contrast, 0f, 0f, 0f, brightness,
  0f, contrast, 0f, 0f, brightness,
  0f, 0f, contrast, 0f, brightness,
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
      colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix)),
    )
    Column(
      modifier = modifier
        .padding(MybraryTheme.space.md),
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
            .width(120.dp)
            .clip(shape = MybraryTheme.shapes.extraSmall),
        )
        Gap(width = MybraryTheme.space.md)
        Column(
          modifier = Modifier
            .fillMaxHeight()
            .weight(1f),
        ) {
          Text(
            text = myBook.title,
            modifier = Modifier.weight(1f),
            color = MybraryTheme.colorScheme.onPrimary,
            style = MybraryTheme.typography.titleLarge,
            overflow = TextOverflow.Ellipsis,
            maxLines = 4,
          )
          Text(
            text = myBook.authors.joinToString { it.name },
            color = MybraryTheme.colorScheme.onPrimary,
            style = MybraryTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
          )
        }
      }
    }
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
    )
  }
}
