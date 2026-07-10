package app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.component.NavigationBarContentScaffold
import app.kaito_dogi.mybrary.core.designsystem.ext.plus
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist.component.MyBookCell
import app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist.component.MyBookCellSkeleton
import app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist.component.MyBookListHeader
import app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist.component.MyBookListHeaderSkeleton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MyBookListScreen(
  uiState: MyBookListUiState,
  onSettingClick: () -> Unit,
  onAdditionClick: () -> Unit,
  onMyBookClick: (MyBook) -> Unit,
) {
  NavigationBarContentScaffold(
    topBar = {
      TopAppBar(
        title = {},
        actions = {
          Box(
            modifier = Modifier
              .clip(shape = CircleShape)
              .background(color = MybraryTheme.colorScheme.background.copy(alpha = 0.8f)),
          ) {
            IconButton(
              onClick = onSettingClick,
            ) {
              Icon(
                painter = painterResource(id = R.drawable.icon_settings),
                contentDescription = stringResource(id = R.string.ui_alt_setting),
              )
            }
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
      )
    },
    floatingActionButton = {
      FloatingActionButton(
        onClick = onAdditionClick,
      ) {
        Icon(
          painter = painterResource(id = R.drawable.icon_add),
          contentDescription = stringResource(id = R.string.my_book_list_alt_search_for_books),
        )
      }
    },
  ) { innerPadding ->
    LazyVerticalGrid(
      columns = GridCells.Fixed(count = uiState.numberOfColumns),
      modifier = Modifier.fillMaxSize(),
      contentPadding = innerPadding.plus(
        start = MybraryTheme.spaces.md,
        end = MybraryTheme.spaces.md,
        bottom = MybraryTheme.spaces.md,
      ),
      verticalArrangement = Arrangement.spacedBy(space = MybraryTheme.spaces.sm),
      horizontalArrangement = Arrangement.spacedBy(space = MybraryTheme.spaces.sm),
    ) {
      // お気に入りの本
      uiState.favoriteMyBookList?.let { favoriteMyBookList ->
        if (favoriteMyBookList.isNotEmpty()) {
          item(
            span = { GridItemSpan(currentLineSpan = uiState.numberOfColumns) },
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
              modifier = Modifier.animateItem(),
            )
          }

          item(
            span = { GridItemSpan(currentLineSpan = uiState.numberOfColumns) },
            key = "Spacer:favorite",
          ) {
            Spacer(modifier = Modifier.height(MybraryTheme.spaces.sm))
          }
        }
      }

      // その他の本
      uiState.otherMyBookList?.let { otherMyBookList ->
        if (otherMyBookList.isNotEmpty()) {
          item(
            span = { GridItemSpan(currentLineSpan = uiState.numberOfColumns) },
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
            modifier = Modifier.animateItem(),
          )
        }
      }

      // スケルトン表示
      if (uiState.myBookList == null) {
        item(
          span = { GridItemSpan(currentLineSpan = uiState.numberOfColumns) },
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
      onSettingClick = {},
      onAdditionClick = {},
      onMyBookClick = {},
    )
  }
}
