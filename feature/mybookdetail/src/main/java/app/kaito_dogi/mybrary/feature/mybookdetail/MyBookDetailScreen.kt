package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.BookId
import app.kaito_dogi.mybrary.core.domain.model.ExternalBookId
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.domain.model.User
import app.kaito_dogi.mybrary.core.domain.model.UserId
import app.kaito_dogi.mybrary.feature.mybookdetail.component.MemoRow
import app.kaito_dogi.mybrary.feature.mybookdetail.component.MemoRowSkeleton
import app.kaito_dogi.mybrary.feature.mybookdetail.component.MyBookDetailBottomAppBar
import app.kaito_dogi.mybrary.feature.mybookdetail.component.MyBookDetailBottomSheetContent
import app.kaito_dogi.mybrary.feature.mybookdetail.component.MyBookDetailTopAppBar

@Composable
internal fun MyBookDetailScreen(
  uiState: MyBookDetailUiState,
  snackbarHost: @Composable () -> Unit,
  bottomSheet: @Composable (@Composable ColumnScope.() -> Unit) -> Unit,
  showSnackbar: (String) -> Unit,
  onArchiveClick: () -> Unit,
  onPublicClick: () -> Unit,
  onFavoriteClick: () -> Unit,
  onAdditionClick: () -> Unit,
  onMemoClick: (Memo) -> Unit,
  onFromPageChange: (String) -> Unit,
  onToPageChange: (String) -> Unit,
  onContentChange: (String) -> Unit,
  onSaveClick: () -> Unit,
) {
  Scaffold(
    modifier = Modifier.fillMaxSize(),
    bottomBar = {
      MyBookDetailBottomAppBar(
        isPublic = uiState.myBook.isPublic,
        isFavorite = uiState.myBook.isFavorite,
        onArchiveClick = onArchiveClick,
        onPublicClick = onPublicClick,
        onFavoriteClick = onFavoriteClick,
        onAdditionClick = onAdditionClick,
      )
    },
    snackbarHost = snackbarHost,
  ) { innerPadding ->
    // ヘッダーを edge to edge で表示したいため、top は innerPadding の値を使用しない
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = PaddingValues(
        bottom = innerPadding.calculateBottomPadding(),
      ),
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.space.md),
    ) {
      item {
        MyBookDetailTopAppBar(
          myBook = uiState.myBook,
        )
      }
      if (uiState.memoList == null) {
        // スケルトン表示
        items(
          count = 4,
          key = { "MemoRowSkeleton$it" },
        ) {
          MemoRowSkeleton(
            modifier = Modifier.padding(
              horizontal = MybraryTheme.space.md,
            ),
          )
        }
      } else {
        items(
          items = uiState.memoList,
          key = { it.id.value },
        ) { memo ->
          MemoRow(
            memo = memo,
            onClick = onMemoClick,
            modifier = Modifier.padding(
              horizontal = MybraryTheme.space.md,
            ),
          )
        }
        item {
          // リストの1番下に Arrangement.spacedBy で余白をもたせるため、高さ0の要素を表示
          Spacer(modifier = Modifier.fillMaxWidth())
        }
      }
    }

    if (uiState.isBottomSheetVisible) {
      bottomSheet {
        MyBookDetailBottomSheetContent(
          draftMemo = uiState.draftMemo,
          isContentTextFieldError = uiState.isContentEmptyError,
          onFromPageChange = onFromPageChange,
          onToPageChange = onToPageChange,
          onContentChange = onContentChange,
          onSaveClick = onSaveClick,
          modifier = Modifier.padding(
            horizontal = MybraryTheme.space.md,
          ),
        )
      }
    }
  }

  uiState.shownMessage?.let {
    LaunchedEffect(it) {
      showSnackbar(it)
    }
  }
}

@Preview
@Composable
private fun MyBookDetailScreenPreview() {
  MybraryTheme {
    MyBookDetailScreen(
      uiState = MyBookDetailUiState.createInitialValue(
        myBook = MyBook(
          id = MyBookId(value = 0L),
          bookId = BookId(value = 0L),
          externalId = ExternalBookId(value = "externalId"),
          user = User(
            id = UserId(value = 0L),
            name = "ユーザー名",
          ),
          title = "タイトル",
          imageUrl = Url.Image(value = "imageUrl"),
          isbn10 = "isbn10",
          isbn13 = "isbn13",
          pageCount = Int.MAX_VALUE,
          publisher = "出版社",
          authors = emptyList(),
          isPinned = false,
          isFavorite = false,
          isPublic = false,
          isArchived = false,
        ),
      ),
      snackbarHost = {},
      bottomSheet = {},
      showSnackbar = {},
      onArchiveClick = {},
      onPublicClick = {},
      onFavoriteClick = {},
      onAdditionClick = {},
      onMemoClick = {},
      onFromPageChange = {},
      onToPageChange = {},
      onContentChange = {},
      onSaveClick = {},
    )
  }
}
