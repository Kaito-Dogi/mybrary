package app.kaito_dogi.mybrary.feature.searchbook

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
internal fun SearchBookPage(
//  uiState: SearchBookUiState,
) {
  Scaffold { innerPadding ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding),
      contentAlignment = Alignment.Center,
    ) {
      Text(text = "SearchBook")
    }
  }
}

@Preview
@Composable
private fun SearchBookPagePreview() {
  MybraryTheme {
    SearchBookScreen()
  }
}
