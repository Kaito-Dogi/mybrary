package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.Memo
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.feature.mybookdetail.component.MemoCard
import app.kaito_dogi.mybrary.feature.mybookdetail.component.MyBookDetailBottomAppBar
import app.kaito_dogi.mybrary.feature.mybookdetail.component.MyBookDetailBottomSheetContent
import app.kaito_dogi.mybrary.feature.mybookdetail.component.MyBookDetailTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MyBookDetailPage(
  uiState: MyBookDetailUiState,
  bottomSheetState: SheetState,
  onBackClick: () -> Unit,
  onArchiveClick: () -> Unit,
  onFavoriteClick: () -> Unit,
  onEditClick: () -> Unit,
  onMemoClick: (Memo) -> Unit,
  onModalBottomSheetDismissRequest: () -> Unit,
  onFromPageChange: (String) -> Unit,
  onToPageChange: (String) -> Unit,
  onContentChange: (String) -> Unit,
  onSaveClick: () -> Unit,
) {
  Scaffold(
    modifier = Modifier
      .fillMaxSize()
      .background(MybraryTheme.colorScheme.background),
    bottomBar = {
      MyBookDetailBottomAppBar(
        isFavorite = uiState.myBook.isFavorite,
        onBackClick = onBackClick,
        onArchiveClick = onArchiveClick,
        onFavoriteClick = onFavoriteClick,
        onEditClick = onEditClick,
      )
    },
  ) { innerPadding ->
    // ヘッダーを edge to edge で表示したいため、top は innerPadding の値を使用しない
    LazyColumn(
      contentPadding = PaddingValues(bottom = innerPadding.calculateBottomPadding()),
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.space.md),
    ) {
      item {
        MyBookDetailTopAppBar(myBook = uiState.myBook)
      }
      if (uiState.memoList == null) {
        item {
          Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center,
          ) {
            // 落ちるのでコメントアウト
            // https://stackoverflow.com/questions/77877363/no-virtual-method-atljava-lang-objectilandroidx-compose-animation-core-keyfra
//              CircularProgressIndicator()
            Text(text = "ローディング中…")
          }
        }
      } else {
        items(
          items = uiState.memoList,
          key = { memo -> memo.id.value },
        ) { memo ->
          MemoCard(
            memo = memo,
            onClick = onMemoClick,
            modifier = Modifier.padding(horizontal = MybraryTheme.space.md),
          )
        }
        item {
          // リストの1番下に Arrangement.spacedBy で余白をもたせるため、高さ0の要素を表示
          Spacer(modifier = Modifier.fillMaxWidth())
        }
      }
    }

    if (uiState.isBottomSheetVisible) {
      ModalBottomSheet(
        onDismissRequest = onModalBottomSheetDismissRequest,
        sheetState = bottomSheetState,
      ) {
        MyBookDetailBottomSheetContent(
          draftMemo = uiState.draftMemo,
          onFromPageChange = onFromPageChange,
          onToPageChange = onToPageChange,
          onContentChange = onContentChange,
          onSaveClick = onSaveClick,
          modifier = Modifier
            .padding(horizontal = MybraryTheme.space.md)
            .fillMaxWidth(),
        )
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
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
        ),
      ),
      bottomSheetState = rememberModalBottomSheetState(),
      onBackClick = {},
      onArchiveClick = {},
      onFavoriteClick = {},
      onEditClick = {},
      onMemoClick = {},
      onModalBottomSheetDismissRequest = {},
      onFromPageChange = {},
      onToPageChange = {},
      onContentChange = {},
      onSaveClick = {},
    )
  }
}
