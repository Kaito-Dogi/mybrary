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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.feature.mybookdetail.component.MemoRow
import app.kaito_dogi.mybrary.feature.mybookdetail.component.MyBookDetailTopAppBar

fun NavGraphBuilder.myBookDetailScreen() {
  composable(
    route = MyBookDetailNavHelper.route,
    arguments = listOf(
      navArgument(MyBookDetailNavHelper.navArgName) {
        type = MyBookDetailNavHelper.navArgType
      },
    ),
  ) {
    MyBookDetailScreen()
  }
}

@Composable
private fun MyBookDetailScreen(
  viewModel: MyBookDetailViewModel = viewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  MyBookDetailScreen(
    uiState = uiState,
  )
}

@Composable
private fun MyBookDetailScreen(
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
      items(items = uiState.myBook.memos) { memo ->
        MemoRow(
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
private fun MyBookDetailScreenPreview() {
  MybraryTheme {
    MyBookDetailScreen()
  }
}
