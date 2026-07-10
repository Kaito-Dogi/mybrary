package app.kaito_dogi.mybrary.feature.mybook.destination.mybookdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.Author
import app.kaito_dogi.mybrary.core.domain.model.Genre
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
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
  isFavorite: Boolean,
  onNavigationIconClick: () -> Unit,
  onFavoriteClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = modifier.height(intrinsicSize = IntrinsicSize.Min),
  ) {
    val backgroundColor =
      if (isSystemInDarkTheme()) MybraryTheme.colorScheme.surfaceContainer else MybraryTheme.colorScheme.inverseSurface
    AsyncImage(
      model = myBook.imageUrl.value,
      modifier = Modifier
        .matchParentSize()
        .background(color = backgroundColor)
        .blur(
          radiusX = MybraryTheme.spaces.md,
          radiusY = MybraryTheme.spaces.md,
        ),
      contentDescription = stringResource(id = R.string.my_book_detail_alt_background_image),
      contentScale = ContentScale.FillWidth,
      colorFilter = ColorFilter.colorMatrix(colorMatrix = ColorMatrix(values = ColorMatrix)),
    )

    Column(
      modifier = Modifier
        .windowInsetsPadding(insets = WindowInsets.statusBars)
        .padding(
          top = MybraryTheme.spaces.xs,
          bottom = MybraryTheme.spaces.md,
        ),
      verticalArrangement = Arrangement.spacedBy(space = MybraryTheme.spaces.xs),
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
      ) {
        IconButton(
          onClick = onNavigationIconClick,
        ) {
          Icon(
            painter = painterResource(id = R.drawable.icon_arrow_back),
            contentDescription = stringResource(id = R.string.my_book_detail_alt_back),
            tint = Color.White,
          )
        }

        Spacer(modifier = Modifier.weight(weight = 1f))

        IconButton(onClick = onFavoriteClick) {
          Icon(
            painter = if (isFavorite) {
              painterResource(id = R.drawable.icon_heart_filled)
            } else {
              painterResource(id = R.drawable.icon_heart_outlined)
            },
            contentDescription = if (isFavorite) {
              stringResource(id = R.string.my_book_detail_alt_remove_my_book_from_favorites)
            } else {
              stringResource(id = R.string.my_book_detail_alt_add_my_book_to_favorites)
            },
            tint = Color.White,
          )
        }
      }

      Row(
        modifier = Modifier
          .height(intrinsicSize = IntrinsicSize.Min)
          .padding(horizontal = MybraryTheme.spaces.md),
        horizontalArrangement = Arrangement.spacedBy(space = MybraryTheme.spaces.md),
      ) {
        BookImage(
          title = myBook.title,
          imageUrl = myBook.imageUrl,
          modifier = Modifier.width(width = MybraryTheme.dimens.bookWidthMd),
        )

        Column(
          verticalArrangement = Arrangement.spacedBy(space = MybraryTheme.spaces.xxs),
        ) {
          Text(
            text = myBook.title,
            modifier = Modifier
              .fillMaxWidth()
              .weight(weight = 1f),
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            maxLines = 4,
            style = MybraryTheme.typography.titleMedium,
          )

          if (myBook.authorList.isNotEmpty()) {
            Text(
              text = myBook.authorList.joinToString { it.name },
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
}

@Preview
@Composable
private fun MyBookDetailTopAppBarPreview() {
  MybraryTheme {
    MyBookDetailTopAppBar(
      myBook = MyBook(
        id = MyBookId(value = ""),
        title = "タイトル\nタイトル\nタイトル\nタイトル\nタイトル",
        imageUrl = Url.Image(value = "imageUrl"),
        authorList = List(10) { Author(name = "著者$it") },
        publisher = "出版社",
        isbn = "isbn",
        genre = Genre.All,
        isPinned = false,
        isFavorite = false,
        isArchived = false,
      ),
      isFavorite = false,
      onNavigationIconClick = {},
      onFavoriteClick = {},
    )
  }
}
