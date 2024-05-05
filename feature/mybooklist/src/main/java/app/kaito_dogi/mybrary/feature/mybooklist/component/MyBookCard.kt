package app.kaito_dogi.mybrary.feature.mybooklist.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.feature.mybooklist.R
import coil.compose.AsyncImage

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
    shape = RoundedCornerShape(MybraryTheme.space.xxs),
  ) {
    AsyncImage(
      model = myBook.imageUrl,
      contentDescription = "${myBook.title}の表紙画像",
      modifier = Modifier.aspectRatio(210f / 297f),
      placeholder = painterResource(id = R.drawable.mybooklist_my_book_card_placeholder),
      error = painterResource(id = R.drawable.mybooklist_my_book_card_placeholder),
      contentScale = ContentScale.Fit,
    )
  }
}

@Preview
@Composable
private fun MyBookCardPreview() {
  MybraryTheme {
    MyBookCard(
      myBook = MyBook(
        id = MyBookId(0L),
        externalId = "MyBook",
        title = "MyBook",
        author = "MyBook",
        imageUrl = "MyBook",
        isPinned = false,
        isFavorite = false,
        isArchived = false,
        memos = emptyList(),
      ),
      onClick = {},
    )
  }
}
