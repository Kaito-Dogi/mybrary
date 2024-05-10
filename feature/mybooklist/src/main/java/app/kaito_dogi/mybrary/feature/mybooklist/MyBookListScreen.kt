package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.feature.mybooklist.component.MyBookCard

const val myBookListRoute = "myBookList"

fun NavGraphBuilder.myBookListScreen(
  onAdditionClick: () -> Unit,
  onMyBookClick: (MyBook) -> Unit,
) {
  composable(
    route = myBookListRoute,
  ) {
    MyBookListScreen(
      onAdditionClick = onAdditionClick,
      onMyBookClick = onMyBookClick,
    )
  }
}

@Composable
private fun MyBookListScreen(
  onAdditionClick: () -> Unit,
  onMyBookClick: (MyBook) -> Unit,
  viewModel: MyBookListViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  LaunchedEffect(Unit) {
    viewModel.init()
  }

  MyBookListScreen(
    uiState = uiState,
    onAdditionClick = onAdditionClick,
    onMyBookClick = onMyBookClick,
  )
}

@Composable
private fun MyBookListScreen(
  uiState: MyBookListUiState,
  onAdditionClick: () -> Unit,
  onMyBookClick: (MyBook) -> Unit,
) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(MybraryTheme.colorScheme.background)
      .padding(horizontal = MybraryTheme.space.md),
  ) {
    LazyVerticalGrid(
      columns = GridCells.Fixed(uiState.numberOfColumns),
      contentPadding = WindowInsets.systemBars.asPaddingValues(),
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.space.sm),
      horizontalArrangement = Arrangement.spacedBy(MybraryTheme.space.sm),
    ) {
      items(items = uiState.myBookList) {
        MyBookCard(
          myBook = it,
          onClick = onMyBookClick,
        )
      }
    }

    FloatingActionButton(
      onClick = onAdditionClick,
      modifier = Modifier
        .padding(MybraryTheme.space.md)
        .align(Alignment.BottomEnd),
    ) {
      Icon(imageVector = Icons.Default.Add, contentDescription = "書籍検索画面に遷移")
    }
  }
}

@Preview
@Composable
private fun MyBookListScreenPreview() {
  MybraryTheme {
    MyBookListScreen(
      onAdditionClick = {},
      onMyBookClick = {},
    )
  }
}
