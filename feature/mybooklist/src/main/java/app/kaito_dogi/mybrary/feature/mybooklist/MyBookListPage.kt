package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.feature.mybooklist.component.MyBookCard

@Composable
internal fun MyBookListPage(
  uiState: MyBookListUiState,
  onAdditionClick: () -> Unit,
  onMyBookClick: (MyBook) -> Unit,
) {
  Scaffold(
    modifier = Modifier
      .fillMaxSize()
      .background(MybraryTheme.colorScheme.background)
      .padding(horizontal = MybraryTheme.space.md),
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
    if (uiState.myBookList == null) {
      Box(
        modifier = Modifier
          .fillMaxSize()
          .padding(innerPadding),
        contentAlignment = Alignment.Center,
      ) {
        // 落ちるのでコメントアウト
        // https://stackoverflow.com/questions/77877363/no-virtual-method-atljava-lang-objectilandroidx-compose-animation-core-keyfra
//              CircularProgressIndicator()
        Text(text = "ローディング中…")
      }
    } else {
      LazyVerticalGrid(
        columns = GridCells.Fixed(uiState.numberOfColumns),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(MybraryTheme.space.sm),
        horizontalArrangement = Arrangement.spacedBy(MybraryTheme.space.sm),
      ) {
        items(
          items = uiState.myBookList,
          key = { myBook -> myBook.id.value },
        ) {
          MyBookCard(
            myBook = it,
            onClick = onMyBookClick,
          )
        }
      }
    }
  }
}

// TODO: Loading, Success 時の Preview を表示する
@Preview
@Composable
private fun MyBookListPagePreview() {
  MybraryTheme {
    MyBookListPage(
      uiState = MyBookListUiState.InitialValue,
      onAdditionClick = {},
      onMyBookClick = {},
    )
  }
}
