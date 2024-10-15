package app.kaito_dogi.mybrary.feature.mybook.destination.mybookdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.component.NavigationBarContentScaffold
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.Genre
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.ui.R
import app.kaito_dogi.mybrary.feature.mybook.destination.mybookdetail.component.MemoRow
import app.kaito_dogi.mybrary.feature.mybook.destination.mybookdetail.component.MemoRowSkeleton
import app.kaito_dogi.mybrary.feature.mybook.destination.mybookdetail.component.MyBookDetailBottomSheetContent
import app.kaito_dogi.mybrary.feature.mybook.destination.mybookdetail.component.MyBookDetailTopAppBar

@Composable
internal fun MyBookDetailScreen(
  uiState: MyBookDetailUiState,
  snackbarHost: @Composable () -> Unit,
  bottomSheet: @Composable (@Composable ColumnScope.() -> Unit) -> Unit,
  onNavigationIconClick: () -> Unit,
  onFavoriteClick: () -> Unit,
  onPublicClick: () -> Unit,
  onArchiveClick: () -> Unit,
  onAdditionClick: () -> Unit,
  onMemoClick: (Memo) -> Unit,
  onStartPageChange: (String) -> Unit,
  onEndPageChange: (String) -> Unit,
  onContentChange: (String) -> Unit,
  onSaveClick: () -> Unit,
) {
  NavigationBarContentScaffold(
    snackbarHost = snackbarHost,
    floatingActionButton = {
      FloatingActionButton(
        onClick = onAdditionClick,
      ) {
        Icon(
          painter = painterResource(R.drawable.icon_add),
          contentDescription = stringResource(R.string.my_book_detail_alt_create_a_memo),
        )
      }
    },
  ) { innerPadding ->
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      // ヘッダーを edge to edge で表示したいため、top は innerPadding の値を使用しない
      contentPadding = PaddingValues(
        bottom = innerPadding.calculateBottomPadding() + MybraryTheme.spaces.md,
      ),
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.md),
    ) {
      // ヘッダー
      item(key = "MyBookDetailTopAppBar") {
        MyBookDetailTopAppBar(
          myBook = uiState.myBook,
          isPublic = uiState.myBook.isPublic,
          isFavorite = uiState.myBook.isFavorite,
          onNavigationIconClick = onNavigationIconClick,
          onFavoriteClick = onFavoriteClick,
          onPublicClick = onPublicClick,
          onArchiveClick = onArchiveClick,
        )
      }

      // メモ
      uiState.memoList?.let {
        items(
          items = uiState.memoList,
          key = { it.id.value },
        ) { memo ->
          MemoRow(
            memo = memo,
            onClick = onMemoClick,
            modifier = Modifier.padding(horizontal = MybraryTheme.spaces.md),
          )
        }
      }

      // スケルトン表示
      if (uiState.memoList == null) {
        items(
          count = 4,
          key = { "MemoRowSkeleton$it" },
        ) {
          MemoRowSkeleton(
            modifier = Modifier.padding(horizontal = MybraryTheme.spaces.md),
          )
        }
      }
    }

    if (uiState.isBottomSheetVisible) {
      bottomSheet {
        MyBookDetailBottomSheetContent(
          draftMemo = uiState.draftMemo,
          isContentTextFieldError = uiState.isContentEmptyError,
          onStartPageChange = onStartPageChange,
          onEndPageChange = onEndPageChange,
          onContentChange = onContentChange,
          onSaveClick = onSaveClick,
          modifier = Modifier.padding(horizontal = MybraryTheme.spaces.md),
        )
      }
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
          id = MyBookId(value = ""),
          title = "タイトル",
          imageUrl = Url.Image(value = "imageUrl"),
          authorList = emptyList(),
          publisher = "出版社",
          isbn = "isbn",
          genre = Genre.All,
          isPinned = false,
          isFavorite = false,
          isPublic = false,
          isArchived = false,
        ),
      ),
      snackbarHost = {},
      bottomSheet = {},
      onNavigationIconClick = {},
      onFavoriteClick = {},
      onPublicClick = {},
      onArchiveClick = {},
      onAdditionClick = {},
      onMemoClick = {},
      onStartPageChange = {},
      onEndPageChange = {},
      onContentChange = {},
      onSaveClick = {},
    )
  }
}
