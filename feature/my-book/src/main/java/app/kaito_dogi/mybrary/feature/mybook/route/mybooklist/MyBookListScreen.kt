package app.kaito_dogi.mybrary.feature.mybook.route.mybooklist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Icon
import app.kaito_dogi.mybrary.core.designsystem.extension.plus
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.ui.R
import app.kaito_dogi.mybrary.feature.mybook.route.mybooklist.component.MyBookCell
import app.kaito_dogi.mybrary.feature.mybook.route.mybooklist.component.MyBookCellSkeleton
import app.kaito_dogi.mybrary.feature.mybook.route.mybooklist.component.MyBookListHeader
import app.kaito_dogi.mybrary.feature.mybook.route.mybooklist.component.MyBookListHeaderSkeleton

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
          iconResId = R.drawable.icon_add,
          altResId = R.string.my_book_list_alt_search_for_books,
        )
      }
    },
  ) { innerPadding ->
    LazyVerticalGrid(
      columns = GridCells.Fixed(uiState.numberOfColumns),
      modifier = Modifier.fillMaxSize(),
      contentPadding = innerPadding.plus(
        start = MybraryTheme.space.md,
        top = MybraryTheme.space.sm,
        end = MybraryTheme.space.md,
        bottom = MybraryTheme.space.md,
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
            MyBookListHeader(
              titleResId = R.string.my_book_list_text_favorite_my_books,
            )
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
            Spacer(modifier = Modifier.height(MybraryTheme.space.xl))
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
              titleResId = if (uiState.areAllMyBooksInOtherList) R.string.my_book_list_text_all_my_books else R.string.my_book_list_text_other_my_books,
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
