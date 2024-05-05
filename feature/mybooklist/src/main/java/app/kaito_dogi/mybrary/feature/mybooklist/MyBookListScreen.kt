package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
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
  viewModel: MyBookListViewModel = viewModel(),
  onAdditionClick: () -> Unit,
  onMyBookClick: (MyBook) -> Unit,
) {
  MyBookListScreen(
    onAdditionClick = onAdditionClick,
    onMyBookClick = onMyBookClick,
  )
}

@Composable
private fun MyBookListScreen(
//  uiState
  onAdditionClick: () -> Unit,
  onMyBookClick: (MyBook) -> Unit,
) {
  Scaffold(
    floatingActionButton = {
      FloatingActionButton(onClick = onAdditionClick) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "MyBook 追加ボタン")
      }
    },
  ) { innerPadding ->
    Box(
      modifier = Modifier
          .fillMaxSize()
          .padding(innerPadding),
      contentAlignment = Alignment.Center,
    ) {
      Text(text = "MyBookList")
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
