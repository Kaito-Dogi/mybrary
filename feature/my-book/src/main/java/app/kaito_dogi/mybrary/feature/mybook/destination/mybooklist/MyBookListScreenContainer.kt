package app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.kaito_dogi.mybrary.core.designsystem.component.Text

@Composable
internal fun MyBookListScreenContainer() {
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center,
  ) {
    Text(text = "MyBookList")
  }
}
