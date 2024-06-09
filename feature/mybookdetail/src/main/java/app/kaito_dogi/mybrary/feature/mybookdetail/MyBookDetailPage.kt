package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.feature.mybookdetail.component.MemoCard
import app.kaito_dogi.mybrary.feature.mybookdetail.component.MyBookDetailBottomAppBar
import app.kaito_dogi.mybrary.feature.mybookdetail.component.MyBookDetailTopAppBar

@Composable
internal fun MyBookDetailPage(
  uiState: MyBookDetailUiState,
  onBackClick: () -> Unit,
  onArchiveClick: () -> Unit,
  onFavoriteClick: () -> Unit,
  onEditClick: () -> Unit,
) {
  Scaffold(
    modifier = Modifier
      .fillMaxSize()
      .background(MybraryTheme.colorScheme.background),
    bottomBar = {
      MyBookDetailBottomAppBar(
        onBackClick = onBackClick,
        onArchiveClick = onArchiveClick,
        onFavoriteClick = onFavoriteClick,
        onEditClick = onEditClick,
      )
    },
  ) { innerPadding ->
    LazyColumn(
      contentPadding = innerPadding,
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.space.md),
    ) {
      item {
        MyBookDetailTopAppBar(myBook = uiState.myBook)
      }
      when (uiState) {
        is MyBookDetailUiState.Loading -> {
          item {
            Box(
              modifier = Modifier.fillMaxWidth(),
              contentAlignment = Alignment.Center,
            ) {
              // 落ちるのでコメントアウト
              // https://stackoverflow.com/questions/77877363/no-virtual-method-atljava-lang-objectilandroidx-compose-animation-core-keyfra
//              CircularProgressIndicator()
            }
          }
        }

        is MyBookDetailUiState.Success -> {
          items(
            items = uiState.memos,
            key = { memo -> memo.id.value },
          ) { memo ->
            MemoCard(
              memo = memo,
              onClick = {},
              modifier = Modifier.padding(horizontal = MybraryTheme.space.md),
            )
          }
          item {
            // リストの1番下に Arrangement.spacedBy で余白をもたせるため、高さ0の要素を表示
            Spacer(modifier = Modifier.fillMaxWidth())
          }
        }
      }
    }
  }
}

// TODO: Loading, Success 時の Preview を表示する
@Preview
@Composable
private fun MyBookDetailPagePreview() {
  MybraryTheme {
    MyBookDetailPage(
      uiState = MyBookDetailUiState.Loading(
        myBook = MyBook(
          id = MyBookId(0L),
          externalId = "externalId",
          title = "title",
          authors = "authors",
          imageUrl = Url.Image(value = "imageUrl"),
          isPinned = false,
          isFavorite = false,
          isArchived = false,
        ),
      ),
      onBackClick = {},
      onArchiveClick = {},
      onFavoriteClick = {},
      onEditClick = {},
    )
  }
}
