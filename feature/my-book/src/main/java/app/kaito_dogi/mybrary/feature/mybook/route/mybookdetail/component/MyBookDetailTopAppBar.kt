package app.kaito_dogi.mybrary.feature.mybook.route.mybookdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.Author
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.model.User
import app.kaito_dogi.mybrary.core.domain.model.UserId
import app.kaito_dogi.mybrary.core.ui.R
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
    modifier = modifier.height(IntrinsicSize.Min),
  ) {
    AsyncImage(
      model = myBook.imageUrl.value,
      modifier = Modifier
        .matchParentSize()
        .background(MybraryTheme.colorScheme.primary)
        .blur(
          radiusX = MybraryTheme.spaces.md,
          radiusY = MybraryTheme.spaces.md,
        ),
      contentDescription = stringResource(id = R.string.my_book_detail_alt_background_image),
      contentScale = ContentScale.FillWidth,
      colorFilter = ColorFilter.colorMatrix(ColorMatrix(ColorMatrix)),
    )

    Row(
      modifier = Modifier
        .height(IntrinsicSize.Min)
        .padding(
          start = MybraryTheme.spaces.md,
          top = MybraryTheme.spaces.md + WindowInsets.systemBars
            .asPaddingValues()
            .calculateTopPadding(),
          end = MybraryTheme.spaces.md,
          bottom = MybraryTheme.spaces.md,
        ),
      horizontalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.md),
    ) {
      BookImage(
        imageUrl = myBook.imageUrl,
        modifier = Modifier.width(MybraryTheme.dimens.bookWidthMd),
      )

      Column(
        verticalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.xs),
      ) {
        Text(
          text = myBook.title,
          modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
          color = Color.White,
          overflow = TextOverflow.Ellipsis,
          maxLines = 3,
          style = MybraryTheme.typography.titleLarge,
        )

        if (myBook.authors.isNotEmpty()) {
          Text(
            text = myBook.authors.joinToString { it.name },
            modifier = Modifier.fillMaxWidth(),
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            style = MybraryTheme.typography.bodyMedium,
          )
        }

        Text(
          text = myBook.publisher,
          modifier = Modifier.fillMaxWidth(),
          color = Color.White,
          overflow = TextOverflow.Ellipsis,
          maxLines = 1,
          style = MybraryTheme.typography.bodyMedium,
        )
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
        id = MyBookId(value = ""),
        user = User(
          id = UserId(value = "userId"),
          name = "ユーザー名",
        ),
        bookId = BookId(value = ""),
        title = "タイトル\nタイトル\nタイトル\nタイトル",
        imageUrl = Url.Image(value = "imageUrl"),
        isbn = "isbn",
        publisher = "出版社",
        authors = List(10) { Author(name = "著者$it") },
        isPinned = false,
        isFavorite = false,
        isPublic = false,
        isArchived = false,
      ),
    )
  }
}
