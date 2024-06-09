package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.feature.mybookdetail.component.MemoCard
import app.kaito_dogi.mybrary.feature.mybookdetail.component.MyBookDetailTopAppBar

@Composable
internal fun MyBookDetailPage(
  uiState: MyBookDetailUiState,
) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(MybraryTheme.colorScheme.background),
  ) {
    LazyColumn(
      contentPadding = PaddingValues(
        bottom = WindowInsets.systemBars.asPaddingValues().calculateBottomPadding(),
      ),
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.space.md),
    ) {
      item {
        MyBookDetailTopAppBar(myBook = uiState.myBook)
      }
      items(
        items = uiState.myBook.memos,
        key = { memo -> memo.id.value },
      ) { memo ->
        MemoCard(
          memo = memo,
          onClick = {},
          modifier = Modifier.padding(horizontal = MybraryTheme.space.md),
        )
      }
    }
  }
}

@Preview
@Composable
private fun MyBookDetailPagePreview() {
  MybraryTheme {
    MyBookDetailPage(
      uiState = MyBookDetailUiState.createInitialValue(
        myBook = MyBook(
          id = MyBookId(0L),
          externalId = "externalId",
          title = "title",
          authors = "authors",
          imageUrl = Url.Image(value = "imageUrl"),
          isPinned = false,
          isFavorite = false,
          isArchived = false,
          memos = emptyList(),
        ),
      ),
    )
  }
}
