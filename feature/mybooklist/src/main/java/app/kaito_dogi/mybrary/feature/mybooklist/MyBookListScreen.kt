package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.feature.mybooklist.component.MyBookCell
import app.kaito_dogi.mybrary.feature.mybooklist.component.MyBookCellSkeleton
import app.kaito_dogi.mybrary.feature.mybooklist.component.MyBookListHeader
import app.kaito_dogi.mybrary.feature.mybooklist.component.MyBookListHeaderSkeleton

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun MyBookListScreen(
  uiState: MyBookListUiState,
  onAdditionClick: () -> Unit,
  onMyBookClick: (MyBook) -> Unit,
) {
  Scaffold(
    floatingActionButton = {
      FloatingActionButton(
        onClick = onAdditionClick,
      ) {
        Icon(
          imageVector = Icons.Default.Add,
          contentDescription = "書籍検索画面に遷移",
        )
      }
    },
  ) { innerPadding ->
    LazyVerticalGrid(
      columns = GridCells.Fixed(uiState.numberOfColumns),
      modifier = Modifier.fillMaxSize(),
      contentPadding = PaddingValues(
        start = MybraryTheme.space.md,
        top = MybraryTheme.space.sm + innerPadding.calculateTopPadding(),
        end = MybraryTheme.space.md,
        bottom = MybraryTheme.space.md + innerPadding.calculateBottomPadding(),
      ),
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.space.sm),
      horizontalArrangement = Arrangement.spacedBy(MybraryTheme.space.sm),
    ) {
      // お気に入りの本
      uiState.favoriteMyBookList?.let { favoriteMyBookList ->
        if (favoriteMyBookList.isNotEmpty()) {
          item(
            span = { GridItemSpan(uiState.numberOfColumns) },
            key = "MyBookListHeader:favorite",
          ) {
            MyBookListHeader(title = "お気に入りの本")
          }
          items(
            items = favoriteMyBookList,
            key = { it.id.value },
          ) { favoriteMyBook ->
            MyBookCell(
              myBook = favoriteMyBook,
              onClick = onMyBookClick,
              modifier = Modifier.animateItemPlacement(),
            )
          }
          item(
            span = { GridItemSpan(uiState.numberOfColumns) },
            key = "Spacer:favorite",
          ) {
            Spacer(modifier = Modifier.height(MybraryTheme.space.xxl))
          }
        }
      }

      // その他の本
      uiState.otherMyBookList?.let { otherMyBookList ->
        if (otherMyBookList.isNotEmpty()) {
          item(
            span = { GridItemSpan(uiState.numberOfColumns) },
            key = "MyBookListHeader:other",
          ) {
            MyBookListHeader(
              title = if (uiState.areAllMyBooksInOtherList) {
                "すべての本"
              } else {
                "その他の本"
              },
            )
          }
        }
        items(
          items = otherMyBookList,
          key = { it.id.value },
        ) { otherMyBook ->
          MyBookCell(
            myBook = otherMyBook,
            onClick = onMyBookClick,
            modifier = Modifier.animateItemPlacement(),
          )
        }
      }

      // スケルトン表示
      if (uiState.myBookList == null) {
        item(
          span = { GridItemSpan(uiState.numberOfColumns) },
          key = "MyBookListHeaderSkeleton",
        ) {
          MyBookListHeaderSkeleton()
        }
        items(
          count = 4,
          key = { "MyBookCellSkeleton$it" },
        ) {
          MyBookCellSkeleton()
        }
      }
    }
  }
}

// TODO: Loading, Success 時の Preview を表示する
@Preview
@Composable
private fun MyBookListScreenPreview() {
  MybraryTheme {
    MyBookListScreen(
      uiState = MyBookListUiState.InitialValue,
      onAdditionClick = {},
      onMyBookClick = {},
    )
  }
}
